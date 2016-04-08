package org.tuxdevelop.spring.cloud.demo.product.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.tuxdevelop.spring.cloud.demo.product.service.repository.ProductRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.Product;

@EnableEurekaClient
@SpringBootApplication
public class ProductServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ProductRepository productRepository) {
        return args -> {
            productRepository.save(new Product("Spring Cloud Netflix", 99.99));
            productRepository.save(new Product("Spring Data Jpa", 20.00));
            productRepository.save(new Product("Spring Boot", 0.00));
            productRepository.save(new Product("Spring Boot in Action - eBook", 19.99));
        };
    }
}
