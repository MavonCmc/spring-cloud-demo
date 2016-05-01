package org.tuxdevelop.spring.cloud.demo.order.service.logic;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.order.service.repository.OrderRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.List;

@Component
public class OrderBean implements InitializingBean {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderBean(final OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(final Order order) {
        return orderRepository.save(order);
    }

    public Order get(final Long orderId) {
        return orderRepository.findById(orderId);
    }

    public List<Order> getByCustomerNumber(final Long customerNumber) {
        return orderRepository.findByCustomerNumber(customerNumber);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        assert orderRepository != null;
    }
}
