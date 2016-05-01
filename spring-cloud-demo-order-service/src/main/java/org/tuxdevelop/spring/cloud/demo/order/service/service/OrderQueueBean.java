package org.tuxdevelop.spring.cloud.demo.order.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.tuxdevelop.spring.cloud.demo.order.service.repository.OrderRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

@MessageEndpoint
public class OrderQueueBean {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderQueueBean(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @ServiceActivator(inputChannel = Sink.INPUT)
    public void saveOrder(final Order order) {
        orderRepository.save(order);
    }
}
