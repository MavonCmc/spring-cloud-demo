package org.tuxdevelop.spring.cloud.demo.service.dto.order;

import lombok.Data;

@Data
public class OrderItem {

	private Long orderItemId;
	private Double price;

}
