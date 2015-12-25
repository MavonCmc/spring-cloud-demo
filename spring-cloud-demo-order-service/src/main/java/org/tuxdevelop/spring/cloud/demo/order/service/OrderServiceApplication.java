package org.tuxdevelop.spring.cloud.demo.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class OrderServiceApplication {

	public static void main(final String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
