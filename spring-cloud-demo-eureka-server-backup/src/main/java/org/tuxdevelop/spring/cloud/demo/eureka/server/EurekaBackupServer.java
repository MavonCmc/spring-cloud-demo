package org.tuxdevelop.spring.cloud.demo.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaBackupServer {

    public static void main(final String[] args) {
        SpringApplication.run(EurekaBackupServer.class, args);
    }

}
