package org.tuxdevelop.spring.cloud.demo.order.service.repository;

import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.repository.MapRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.order.Order;

@Repository
public class OrderRepository extends MapRepository<Order> {


}
