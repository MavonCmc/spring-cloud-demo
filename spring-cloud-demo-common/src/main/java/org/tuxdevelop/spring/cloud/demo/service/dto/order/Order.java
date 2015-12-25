package org.tuxdevelop.spring.cloud.demo.service.dto.order;

import java.util.Collection;

import lombok.Data;

@Data
public class Order {
	
	private Long orderId;
	private String customerNumber;
	private String isoCountryCode;
	private Collection<OrderItem> orderItems;
	private Double totalPrice;

}
