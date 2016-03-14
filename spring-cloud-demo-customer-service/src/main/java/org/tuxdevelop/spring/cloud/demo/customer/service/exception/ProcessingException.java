package org.tuxdevelop.spring.cloud.demo.customer.service.exception;


public class ProcessingException extends RuntimeException {

    public ProcessingException(final String message) {
        super(message);
    }
}
