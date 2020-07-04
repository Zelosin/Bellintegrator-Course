package com.zelosin.bellproject.exception;

public class DataBaseResultException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataBaseResultException(String message, Throwable cause) {
        super(message, cause);
    }
}
