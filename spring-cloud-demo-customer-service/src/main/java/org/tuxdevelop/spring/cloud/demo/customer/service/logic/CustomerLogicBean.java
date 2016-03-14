package org.tuxdevelop.spring.cloud.demo.customer.service.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.customer.service.exception.NoSuchCustomerException;
import org.tuxdevelop.spring.cloud.demo.customer.service.exception.ProcessingException;
import org.tuxdevelop.spring.cloud.demo.customer.service.repository.CustomerRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

@Component
public class CustomerLogicBean {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerLogicBean(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //TODO: business validation
    public Customer save(final Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer get(final Long customerNumber) {
        final Customer customer = customerRepository.findById(customerNumber);
        if (customer == null) {
            throw new NoSuchCustomerException("The Customer with the customerNumber: " + customer + " does not exist");
        }
        return customer;
    }

    //TODO business validation
    public void delete(final Customer customer) {
        if (!customerRepository.delete(customer)) {
            throw new ProcessingException("could not delete customer");
        }
    }


}
