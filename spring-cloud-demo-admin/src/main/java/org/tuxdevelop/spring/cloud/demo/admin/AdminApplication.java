package org.tuxdevelop.spring.cloud.demo.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EnableAdminServer
@SpringBootApplication
public class AdminApplication {

    public static void main(final String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
