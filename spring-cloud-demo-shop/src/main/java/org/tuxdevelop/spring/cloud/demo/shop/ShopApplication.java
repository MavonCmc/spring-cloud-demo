package org.tuxdevelop.spring.cloud.demo.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ShopApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ShopApplication.class, args);
    }

}
