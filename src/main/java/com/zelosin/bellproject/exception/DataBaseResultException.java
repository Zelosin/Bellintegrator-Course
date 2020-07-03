package com.zelosin.bellproject.exception;

public class DataBaseResultException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataBaseResultException() {
    }

    public DataBaseResultException(String message) {
        super(message);
    }
}
