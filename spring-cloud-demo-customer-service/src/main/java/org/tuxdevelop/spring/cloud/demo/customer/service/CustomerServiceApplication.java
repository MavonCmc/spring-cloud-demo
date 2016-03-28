package org.tuxdevelop.spring.cloud.demo.customer.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.RegistrationRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Login;
import org.tuxdevelop.spring.cloud.demo.service.dto.registration.Registration;

@EnableEurekaClient
@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final CustomerRepository customerRepository,
                                               final RegistrationRepository registrationRepository) {

        return args -> {
            final Customer donnie = customerRepository.save(new Customer("Donnie", "Darko", "US", "donnie@darko.com"));
            registrationRepository.save(new Registration(new Login("donnie", "donnie"), donnie.getId()));
            final Customer jeff = customerRepository.save(new Customer("Jeff", "Mills", "US", "jeff.mills@example.com"));
            registrationRepository.save(new Registration(new Login("jeff", "jeff"), jeff.getId()));
        };
    }

}
