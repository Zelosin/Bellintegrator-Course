package com.zelosin.bellproject.controller;


import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.view.ErrorView;
import com.zelosin.bellproject.view.ResultView;
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
     * Обработчик DataBaseResultException-исключения
     * @param exception  объект исключения
     * @return  DTO-информация об ошибке
     */
    @ResponseBody
    @ExceptionHandler(value = DataBaseResultException.class)
    public Object handleDataBaseException(DataBaseResultException exception) {
        return new ErrorView(exception.getMessage(), 3111);
    }

    /**
     * Обработчик валидационных ошибок DTO
     * @param exception  объект исключения
     * @return  DTO-информация об ошибке
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleArgumentException(MethodArgumentNotValidException exception){
        return new ErrorView("Переданы не все аргументы", 3108);
    }
}