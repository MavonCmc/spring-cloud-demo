package org.tuxdevelop.spring.cloud.demo.customer.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
