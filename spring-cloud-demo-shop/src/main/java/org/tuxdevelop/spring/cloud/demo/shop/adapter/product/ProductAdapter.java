package org.tuxdevelop.spring.cloud.demo.shop.adapter.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.Product;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.AbstractAdapter;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductAdapter extends AbstractAdapter {

    private static final String BASE_URL = "http://localhost:9000/product-service/products";

    private final RestTemplate restTemplate;

    @Autowired
    public ProductAdapter(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Product> getAllProducts() {
        final ResponseEntity<Product[]> response = restTemplate.getForEntity(BASE_URL, Product[].class);
        return Arrays.asList(response.getBody());
    }

    public Product getById(final Long productId) {
        final ResponseEntity<Product> response = restTemplate.getForEntity(BASE_URL + "/{productId}", Product.class,
                productId);
        return response.getBody();
    }

}
