package com.duynb.spring.eureka.service2.exception;

public class DuplicateException extends RuntimeException  {
    public DuplicateException(String message) {
        super(message);
    }
}
