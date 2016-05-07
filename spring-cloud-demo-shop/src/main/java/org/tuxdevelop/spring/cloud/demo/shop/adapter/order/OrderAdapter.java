package org.tuxdevelop.spring.cloud.demo.shop.adapter.order;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.client.OrderClient;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrderAdapter {

    private final OrderWriterChannel orderWriterChannel;
    private final OrderClient orderClient;

    @Autowired
    public OrderAdapter(final OrderWriterChannel orderWriterChannel,
                        final OrderClient orderClient) {
        this.orderWriterChannel = orderWriterChannel;
        this.orderClient = orderClient;
    }

    public void saveOrder(final Order order) {
        final MessageChannel channel = orderWriterChannel.output();
        final Boolean response = channel.send(MessageBuilder.withPayload(order).build());
        if (!response) {
            throw new IllegalStateException("Could not save order!");
        }
    }

    @HystrixCommand(fallbackMethod = "getOrdersFallBack", commandKey = "orderservice")
    public List<Order> getOrdersByCustomerNumber(final Long customerNumber) {
        return orderClient.getOrdersByCustomerNumber(customerNumber);
    }

    public List<Order> getOrdersFallBack(final Long customerId) {
        return new LinkedList<>();
    }

}
