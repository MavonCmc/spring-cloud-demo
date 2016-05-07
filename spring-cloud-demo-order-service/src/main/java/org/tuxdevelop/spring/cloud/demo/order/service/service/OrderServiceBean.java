package org.tuxdevelop.spring.cloud.demo.order.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tuxdevelop.spring.cloud.demo.order.service.logic.OrderBean;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderServiceBean {

    private final OrderBean orderBean;

    @Autowired
    public OrderServiceBean(final OrderBean orderBean) {
        this.orderBean = orderBean;
    }

    @RequestMapping(value = "/{orderid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Order get(@PathVariable("orderid") final Long orderId) {
        return orderBean.get(orderId);
    }


    @RequestMapping(value = "/customers/{customernumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Order> getByCustomerNumber(@PathVariable("customernumber") final Long customerNumber) {
        return orderBean.getByCustomerNumber(customerNumber);
    }
}
