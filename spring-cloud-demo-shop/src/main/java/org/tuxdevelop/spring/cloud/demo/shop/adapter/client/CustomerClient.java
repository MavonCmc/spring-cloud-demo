package org.tuxdevelop.spring.cloud.demo.shop.adapter.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;

@FeignClient(url = "http://localhost:9000/customer-service")
public interface CustomerClient {

    @RequestMapping(value = "/customers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDTO addCustomer(CustomerDTO customerDTO);

    @RequestMapping(value = "/customers/search", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    CustomerDTO findCustomerByUserName(@RequestParam("username") String userName);
}
