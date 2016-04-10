package org.tuxdevelop.spring.cloud.demo.customer.service.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.tuxdevelop.spring.cloud.demo.customer.service.domain.CustomerLogin;

public interface CustomerLoginRepository extends JpaRepository<CustomerLogin, Long> {

    CustomerLogin findByUserName(final String userName);

}
