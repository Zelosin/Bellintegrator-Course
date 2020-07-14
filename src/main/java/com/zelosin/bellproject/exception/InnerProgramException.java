package com.zelosin.bellproject.exception;

/**
 * Необрабатываемое исключение, связанное с внутренней работой программы
 */
public class InnerProgramException extends AutoLogginingException{

    public InnerProgramException(String message, Throwable cause) {
        super(message, cause);
    }

    public InnerProgramException(Throwable cause) {
        super("Произошла внутренняя ошибка приложения", cause);
    }
}
