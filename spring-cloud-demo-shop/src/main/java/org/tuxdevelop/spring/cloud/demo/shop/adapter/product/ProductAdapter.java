package org.tuxdevelop.spring.cloud.demo.shop.adapter.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;
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

    @Cacheable(cacheNames = "products", cacheManager = "productsCacheManager")
    public List<ProductDTO> getAllProducts() {
        final ResponseEntity<ProductDTO[]> response = restTemplate.getForEntity(BASE_URL, ProductDTO[].class);
        return Arrays.asList(response.getBody());
    }

    @Cacheable(cacheNames = "products", key = "#productId", cacheManager = "productsCacheManager")
    public ProductDTO getById(final Long productId) {
        final ResponseEntity<ProductDTO> response = restTemplate.getForEntity(BASE_URL + "/{productId}", ProductDTO.class,
                productId);
        return response.getBody();
    }

}
