package com.duynb.spring.eureka.gateway.exception;

public class DuplicateException extends RuntimeException  {
    public DuplicateException(String message) {
        super(message);
    }
}
