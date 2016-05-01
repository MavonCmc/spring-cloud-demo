package org.tuxdevelop.spring.cloud.demo.shop.adapter.order;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderWriterChannel {

    @Output
    MessageChannel output();
}
