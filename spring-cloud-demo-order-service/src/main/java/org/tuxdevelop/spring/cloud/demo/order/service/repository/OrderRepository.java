package org.tuxdevelop.spring.cloud.demo.order.service.repository;

import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.repository.MapRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

import java.util.LinkedList;
import java.util.List;

@Repository
public class OrderRepository extends MapRepository<Order> {

    public List<Order> findByCustomerNumber(final Long customerNumber) {
        final List<Order> result = new LinkedList<>();
        final List<Order> allOrders = findAll();
        for (final Order order : allOrders) {
            if (order.getCustomerId().equals(customerNumber)) {
                result.add(order);
            }
        }
        return result;
    }


}
