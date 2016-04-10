package org.tuxdevelop.spring.cloud.demo.shop.model;

import lombok.Data;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.CustomerDTO;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.List;

@Data
public class CustomerInfoModel {

    private CustomerDTO customerDTO;
    private List<Order> orderItems;
}
