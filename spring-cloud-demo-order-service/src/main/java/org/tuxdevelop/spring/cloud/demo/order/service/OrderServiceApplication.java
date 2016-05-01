package org.tuxdevelop.spring.cloud.demo.order.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.tuxdevelop.spring.cloud.demo.order.service.repository.OrderRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.OrderItem;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

import java.util.Collection;
import java.util.LinkedList;

@EnableEurekaClient
@SpringBootApplication
@IntegrationComponentScan
@EnableBinding(Sink.class)
public class OrderServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final OrderRepository orderRepository) {
        return args -> {
            final Order order = new Order();
            //donnie
            order.setCustomerId(1L);
            //orders
            final Collection<OrderItem> orderItems = new LinkedList<>();
            //spring boot
            final ProductDTO springBootProduct = new ProductDTO();
            springBootProduct.setId(3L);
            springBootProduct.setPrice(0.0);
            springBootProduct.setDescription("Spring Boot");
            final OrderItem springBoot = new OrderItem();
            springBoot.setProductDTO(springBootProduct);
            springBoot.setId(1L);
            orderItems.add(springBoot);
            //spring data jpa
            final ProductDTO springDataJpaProduct = new ProductDTO();
            springDataJpaProduct.setId(2L);
            springDataJpaProduct.setPrice(20.0);
            springDataJpaProduct.setDescription("Spring Data Jpa");
            final OrderItem springDataJpa = new OrderItem();
            springDataJpa.setProductDTO(springDataJpaProduct);
            springDataJpa.setId(2L);
            orderItems.add(springDataJpa);
            order.setOrderItems(orderItems);
            order.setTotalPrice(20.0);
            orderRepository.save(order);
        };
    }

}
