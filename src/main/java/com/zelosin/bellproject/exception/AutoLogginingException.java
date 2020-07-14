package com.zelosin.bellproject.exception;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Класс исключений, которые будут автоматически логгироваться
 */
public class AutoLogginingException extends RuntimeException
        implements LogginableException, CodeGeneratable{

    /**
     * Служебное поле
     */
    private static final long serialVersionUID = 1L;

    /**
     * Код ошибки
     */
    @Getter
    private Integer exceptionCode;

    /**
     * Логгер
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AutoLogginingException.class);

    public AutoLogginingException(String message, Throwable cause) {
        super(message, cause);
        login(this);
    }

    public AutoLogginingException(String message, Exception e) {
        super(message, e.getCause());
        login(this);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Integer generateRandomCode() {
        exceptionCode = Math.abs(new Random().nextInt());
        return exceptionCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void login(Exception e) {
        LOGGER.error("CODE="+generateRandomCode()+"; massage=" +
                e.getMessage() +"; cause="+ e.getCause());
    }
}
