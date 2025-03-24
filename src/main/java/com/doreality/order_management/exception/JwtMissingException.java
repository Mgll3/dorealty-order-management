package com.doreality.order_management.exception;

public class JwtMissingException extends RuntimeException {

    public JwtMissingException(String message) {
        super(message);
    }
}
