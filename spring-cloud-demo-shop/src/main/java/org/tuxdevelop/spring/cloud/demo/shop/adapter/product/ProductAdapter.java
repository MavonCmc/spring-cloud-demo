package org.tuxdevelop.spring.cloud.demo.shop.adapter.product;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;
import org.tuxdevelop.spring.cloud.demo.shop.adapter.client.ProductClient;

import java.util.LinkedList;
import java.util.List;

@Component
public class ProductAdapter {

    private final ProductClient productClient;

    @Autowired
    public ProductAdapter(final ProductClient productClient) {
        this.productClient = productClient;
    }

    @HystrixCommand(fallbackMethod = "getAllProductsFallback", commandKey = "productservice")
    @Cacheable(cacheNames = "products", cacheManager = "productsCacheManager")
    public List<ProductDTO> getAllProducts() {
        return productClient.getAllProducts();
    }

    @HystrixCommand(commandKey = "productservice")
    @Cacheable(cacheNames = "products", key = "#productId", cacheManager = "productsCacheManager")
    public ProductDTO getById(final Long productId) {
        return productClient.getById(productId);
    }

    public List<ProductDTO> getAllProductsFallback() {
        return new LinkedList<>();
    }

}
