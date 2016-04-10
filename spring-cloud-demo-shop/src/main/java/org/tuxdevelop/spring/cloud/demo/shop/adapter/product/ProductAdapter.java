package org.tuxdevelop.spring.cloud.demo.shop.adapter.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.client.ProductClient;

import java.util.List;

@Component
public class ProductAdapter {

    private final ProductClient productClient;

    @Autowired
    public ProductAdapter(final ProductClient productClient) {
        this.productClient = productClient;
    }

    @Cacheable(cacheNames = "products", cacheManager = "productsCacheManager")
    public List<ProductDTO> getAllProducts() {
        return productClient.getAllProducts();
    }

    @Cacheable(cacheNames = "products", key = "#productId", cacheManager = "productsCacheManager")
    public ProductDTO getById(final Long productId) {
        return productClient.getById(productId);
    }

}
