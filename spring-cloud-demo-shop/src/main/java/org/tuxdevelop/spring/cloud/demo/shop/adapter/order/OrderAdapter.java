package org.tuxdevelop.spring.cloud.demo.shop.adapter.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

@Component
public class OrderAdapter {

    private final OrderWriterChannel orderWriterChannel;

    @Autowired
    public OrderAdapter(final OrderWriterChannel orderWriterChannel) {
        this.orderWriterChannel = orderWriterChannel;
    }

    public void saveOrder(final Order order) {
        final MessageChannel channel = orderWriterChannel.output();
        channel.send(MessageBuilder.withPayload(order).build());
    }

}
