package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.client.CustomerClient;

@Component
public class CustomerAdapter {

    private final CustomerClient customerClient;

    @Autowired
    public CustomerAdapter(final CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public CustomerDTO addCustomer(final CustomerDTO customerDTO) {
        return customerClient.addCustomer(customerDTO);
    }

    public CustomerDTO findCustomerByUserName(final String userName) {
        return customerClient.findCustomerByUserName(userName);
    }
}
