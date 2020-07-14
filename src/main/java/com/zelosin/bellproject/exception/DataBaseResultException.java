package com.zelosin.bellproject.exception;

/**
 * Необрабатываемое исключение, возникающее при неправильной работе с базой данных
 */
public class DataBaseResultException extends AutoLogginingException{

    public DataBaseResultException(String message, Throwable cause) {
        super(message, cause);
    }
}