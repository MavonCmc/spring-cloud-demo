package org.tuxdevelop.spring.cloud.demo.customer.service.repository;

import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.repository.MapRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

@Repository
public class CustomerRepository extends MapRepository<Customer> {


}
