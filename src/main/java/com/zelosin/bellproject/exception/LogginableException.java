package com.zelosin.bellproject.exception;

/**
 * Интерфейс автоматического логирования
 */
@FunctionalInterface
public interface LogginableException {

    /**
     * Метод логирования
     * @param e объект исключения
     */
    void login(Exception e);

}
