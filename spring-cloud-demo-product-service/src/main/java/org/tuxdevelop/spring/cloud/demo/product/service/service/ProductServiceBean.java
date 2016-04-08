package org.tuxdevelop.spring.cloud.demo.product.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tuxdevelop.spring.cloud.demo.product.service.repository.ProductRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.Product;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductServiceBean {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceBean(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @RequestMapping(value = "/{productid}", method = RequestMethod.GET, produces = "application/json")
    public Product getProduct(@PathVariable("productid") final Long productId) {
        return productRepository.findById(productId);
    }


}
