package com.zelosin.bellproject.exception;

/**
 * Необрабатываемое исключение, возникающее при неправильной работе с базой данных
 */
public class DataBaseResultException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public DataBaseResultException(String message, Throwable cause) {
        super(message, cause);
    }
}