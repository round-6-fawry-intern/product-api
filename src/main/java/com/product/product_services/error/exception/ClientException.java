package com.product.product_services.error.exception;

public class ClientException extends RuntimeException{

    public ClientException(String message) {
        super(message);
    }

    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
