package org.tuxdevelop.spring.cloud.demo.shop.adapter.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
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

    public CustomerDTO addCustomer(final CustomerDTO customerDTO) {
        final HttpEntity<CustomerDTO> httpEntity = new HttpEntity<>(customerDTO, prepareHeaders());
        final ResponseEntity<CustomerDTO> response = restTemplate.exchange(BASE_URL, HttpMethod.POST, httpEntity, CustomerDTO
                .class);
        return response.getBody();
    }

    public CustomerDTO findCustomerByUserName(final String userName) {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(BASE_URL + "/search");
        uriComponentsBuilder.queryParam("username", userName);
        final ResponseEntity<CustomerDTO> response = restTemplate.getForEntity(uriComponentsBuilder.toUriString(), CustomerDTO.class);
        return response.getBody();
    }
}
