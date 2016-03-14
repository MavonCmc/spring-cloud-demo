package org.tuxdevelop.spring.cloud.demo.service.dto.order;

import lombok.Data;
import org.tuxdevelop.spring.cloud.demo.service.dto.customer.Customer;

import java.util.Collection;

@Data
public class Order {

    private Long orderId;
    private Customer customer;
    private Collection<OrderItem> orderItems;
    private Double totalPrice;

}
