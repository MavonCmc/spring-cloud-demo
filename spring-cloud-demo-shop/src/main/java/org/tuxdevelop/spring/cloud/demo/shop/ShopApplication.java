package org.tuxdevelop.spring.cloud.demo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.order.OrderWriterChannel;

@EnableFeignClients
@IntegrationComponentScan
@EnableBinding(OrderWriterChannel.class)
@SpringBootApplication
public class ShopApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
