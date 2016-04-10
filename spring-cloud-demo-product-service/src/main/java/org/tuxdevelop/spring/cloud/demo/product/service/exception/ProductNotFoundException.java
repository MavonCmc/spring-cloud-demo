package org.tuxdevelop.spring.cloud.demo.product.service.exception;


public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(final String message) {
        super(message);
    }

}
