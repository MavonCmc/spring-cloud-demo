package org.tuxdevelop.spring.cloud.demo.customer.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.CustomerRegistration;

public interface CustomerRegistrationRepository extends JpaRepository<CustomerRegistration, Long> {

    CustomerRegistration findByCustomerLoginUserName(final String userName);

}
