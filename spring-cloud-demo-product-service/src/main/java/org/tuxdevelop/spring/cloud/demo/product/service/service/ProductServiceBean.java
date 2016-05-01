package org.tuxdevelop.spring.cloud.demo.product.service.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.tuxdevelop.spring.cloud.demo.product.service.Domain.Product;
import org.tuxdevelop.spring.cloud.demo.product.service.exception.ProductNotFoundException;
import org.tuxdevelop.spring.cloud.demo.product.service.repository.ProductRepository;
import org.tuxdevelop.spring.cloud.demo.service.dto.product.ProductDTO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/products")
public class ProductServiceBean {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceBean(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize(value = "hasRole('ROLE_READ')")
    public List<ProductDTO> getProducts() {
        final List<Product> products = productRepository.findAll();
        final List<ProductDTO> productDTOs = new LinkedList<>();
        productDTOs.addAll(products.stream().map(Product::mapToDTO).collect(Collectors.toList()));
        return productDTOs;
    }

    @RequestMapping(value = "/{productid}", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize(value = "hasRole('ROLE_READ')")
    public ProductDTO getProduct(@PathVariable("productid") final Long productId) {
        final Product product = productRepository.findOne(productId);
        final ProductDTO productDTO;
        if (product != null) {
            productDTO = product.mapToDTO();
        } else {
            throw new ProductNotFoundException("No product found for id: " + product);
        }
        return productDTO;
    }


}
