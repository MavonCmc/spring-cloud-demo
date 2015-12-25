package org.tuxdevelop.spring.cloud.demo.order.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.tuxdevelop.spring.cloud.demo.order.service.logic.OrderBean;
import org.tuxdevelop.spring.cloud.demo.service.intf.OrderService;

import lombok.Delegate;

@SuppressWarnings("deprecation")
public class OrderServiceBean implements OrderService {

	@Delegate
	private final OrderBean orderBean;

	@Autowired
	public OrderServiceBean(final OrderBean orderBean){
		this.orderBean = orderBean;
	}
}
