package org.tuxdevelop.spring.cloud.demo.product.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tuxdevelop.spring.cloud.demo.product.service.Domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
