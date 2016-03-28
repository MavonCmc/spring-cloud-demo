package org.tuxdevelop.spring.cloud.demo.shop.model;

import lombok.Data;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.List;

@Data
public class CustomerInfoModel {

    private Customer customer;
    private List<Order> orderItems;
}
