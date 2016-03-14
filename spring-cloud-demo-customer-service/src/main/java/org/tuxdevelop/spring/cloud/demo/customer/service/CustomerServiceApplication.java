package org.tuxdevelop.spring.cloud.demo.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

@EnableEurekaClient
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {

        return new CommandLineRunner() {

            @Autowired
            private CustomerRepository customerRepository;

            @Override
            public void run(final String... args) throws Exception {
                customerRepository.save(new Customer(null, "Donnie", "Darko", "US", "donnie@darko.com"));
                customerRepository.save(new Customer(null, "Jeff", "Mills", "US", "jeff.mills@example.com"));
            }
        };
    }

}
