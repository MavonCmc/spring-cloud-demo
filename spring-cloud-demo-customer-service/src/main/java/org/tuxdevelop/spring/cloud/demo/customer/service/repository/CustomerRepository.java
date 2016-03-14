package org.tuxdevelop.spring.cloud.demo.customer.service.repository;

import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CustomerRepository {

    private AtomicLong currentCustomerNumber;
    private final Map<Long, Customer> customerMap;

    public CustomerRepository() {
        this.currentCustomerNumber = new AtomicLong(1L);
        this.customerMap = new LinkedHashMap<>();
    }

    public Customer save(final Customer customer) {
        final Long customerNumber;
        if (findById(customer.getCustomerNumber()) == null) {
            customerNumber = getNextCustomerNumber();
            customer.setCustomerNumber(customerNumber);
        } else {
            customerNumber = customer.getCustomerNumber();
        }
        customerMap.put(customerNumber, customer);
        return customer;
    }

    public Customer findById(final Long customerNumber) {
        final Customer customer;
        if (customerNumber != null && customerMap.containsKey(customerNumber)) {
            customer = customerMap.get(customerNumber);
        } else {
            customer = null;
        }
        return customer;
    }

    public Boolean delete(final Customer customer) {
        final Boolean result;
        if (findById(customer.getCustomerNumber()) != null) {
            customerMap.remove(customer.getCustomerNumber());
            result = Boolean.TRUE;
        } else {
            result = Boolean.FALSE;
        }
        return result;
    }

    synchronized Long getNextCustomerNumber() {
        return currentCustomerNumber.getAndIncrement();
    }

}
