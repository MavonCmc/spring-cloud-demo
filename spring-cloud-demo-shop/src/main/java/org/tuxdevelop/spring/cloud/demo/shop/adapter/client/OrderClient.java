package org.tuxdevelop.spring.cloud.demo.shop.adapter.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.List;

@FeignClient(url = "http://localhost:9000/order-service")
public interface OrderClient {

    @RequestMapping(value = "/orders/customers/{customernumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<Order> getOrdersByCustomerNumber(@PathVariable("customernumber") Long customerid);

}
