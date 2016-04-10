package org.tuxdevelop.spring.cloud.demo.customer.service;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.Customer;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.CustomerLogin;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.CustomerRegistration;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRegistrationRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRepository;

@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.tuxdevelop.spring.cloud.demo.customer.service.repository")
@EntityScan(basePackages = "org.tuxdevelop.spring.cloud.demo.customer.service.domain")
public class CustomerServiceApplication {

    public static void main(final String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(final CustomerRepository customerRepository,
                                               final CustomerRegistrationRepository customerRegistrationRepository) {

        return args -> {
            final Customer donnie = customerRepository.save(new Customer(null, "Donnie", "Darko", "US", "donnie@darko.com"));
            customerRegistrationRepository.save(new CustomerRegistration(null, new CustomerLogin(null, "donnie", "donnie"), donnie.getCustomerNumber()));
            final Customer jeff = customerRepository.save(new Customer(null, "Jeff", "Mills", "US", "jeff.mills@example.com"));
            customerRegistrationRepository.save(new CustomerRegistration(null, new CustomerLogin(null, "jeff", "jeff"), jeff.getCustomerNumber()));
        };
    }

}
