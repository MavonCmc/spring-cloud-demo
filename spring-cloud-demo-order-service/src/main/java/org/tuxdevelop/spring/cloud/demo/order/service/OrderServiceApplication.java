package org.tuxdevelop.spring.cloud.demo.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.integration.annotation.IntegrationComponentScan;

@EnableEurekaClient
@SpringBootApplication
@IntegrationComponentScan
@EnableBinding(Sink.class)
public class OrderServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}
