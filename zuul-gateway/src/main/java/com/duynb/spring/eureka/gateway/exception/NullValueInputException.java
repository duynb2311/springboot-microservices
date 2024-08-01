package com.duynb.spring.eureka.gateway.exception;

public class NullValueInputException extends RuntimeException{
    public NullValueInputException(String message) {
        super(message);
    }
}
