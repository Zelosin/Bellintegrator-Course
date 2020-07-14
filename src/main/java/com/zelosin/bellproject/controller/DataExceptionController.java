package com.zelosin.bellproject.controller;


import com.zelosin.bellproject.exception.AutoLogginingException;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.exception.InnerProgramException;
import com.zelosin.bellproject.view.ErrorView;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Контроллер-обработчик исключений
 */
@ControllerAdvice
public class DataExceptionController {

    /**
     * Обработчик исключений приложения
     * @param exception  объект исключения
     * @return  DTO-информация об ошибке
     */
    @ResponseBody
    @ExceptionHandler(value = {DataBaseResultException.class, InnerProgramException.class})
    public Object handleDataBaseException(AutoLogginingException exception) {
        return new ErrorView(exception.getMessage(), exception.getExceptionCode());
    }

    /**
     * Обработчик валидационных ошибок DTO
     * @param exception  объект исключения
     * @return  DTO-информация об ошибке
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleArgumentException(MethodArgumentNotValidException exception){
        AutoLogginingException autoLogginingException = new AutoLogginingException("Переданы не все аргументы", exception);
        return new ErrorView(autoLogginingException.getMessage(), autoLogginingException.getExceptionCode());
    }
}