package org.tuxdevelop.spring.cloud.demo.product.service.repository;


import org.springframework.stereotype.Repository;
import org.tuxdevelop.spring.cloud.demo.repository.MapRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.Product;

@Repository
public class ProductRepository extends MapRepository<Product> {


}
