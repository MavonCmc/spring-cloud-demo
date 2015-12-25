package org.tuxdevelop.spring.cloud.demo.order.service.repository;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

@Repository
public class OrderRepository {

	private final AtomicLong currentId;
	private final ConcurrentMap<Long, Order> orders;

	public OrderRepository() {
		orders = new ConcurrentHashMap<>();
		currentId = new AtomicLong(0L);
	}

	public Order save(final Order order) {
		if (orders.containsKey(order.getOrderId())) {
			orders.remove(order.getOrderId());
			orders.put(order.getOrderId(), order);
		} else {
			final Long orderId = getNextId();
			order.setOrderId(orderId);
			orders.put(orderId, order);
		}
		return order;
	}

	public Order get(final Long orderId) {
		return orders.get(orderId);
	}

	Long getNextId() {
		return currentId.incrementAndGet();
	}

}
