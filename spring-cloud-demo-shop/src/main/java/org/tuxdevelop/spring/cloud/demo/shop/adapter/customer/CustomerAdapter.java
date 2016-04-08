package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.AbstractAdapter;

@Component
public class CustomerAdapter extends AbstractAdapter {

    //TODO: externalize properties
    private static final String BASE_URL = "http://localhost:9000/customer-service/customers";

    private final RestTemplate restTemplate;

    @Autowired
    public CustomerAdapter(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer addCustomer(final Customer customer) {
        final HttpEntity<Customer> httpEntity = new HttpEntity<>(customer, prepareHeaders());
        final ResponseEntity<Customer> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, httpEntity, Customer
                .class);
        return response.getBody();
    }
}
