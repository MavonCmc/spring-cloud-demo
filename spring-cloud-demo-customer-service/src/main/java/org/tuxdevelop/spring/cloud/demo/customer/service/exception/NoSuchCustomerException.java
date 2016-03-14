package org.tuxdevelop.spring.cloud.demo.customer.service.exception;


public class NoSuchCustomerException extends RuntimeException {

    public NoSuchCustomerException(final String message) {
        super(message);
    }
}
