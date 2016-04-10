package org.tuxdevelop.spring.cloud.demo.shop.adapter.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

import java.util.List;

@FeignClient(url = "http://localhost:9000/product-service")
public interface ProductClient {

    @RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ProductDTO> getAllProducts();

    @RequestMapping(value = "/products/{productid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    ProductDTO getById(@PathVariable("productid") Long productId);
}
