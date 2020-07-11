package com.zelosin.bellproject.controller;


import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.view.ErrorView;
import com.zelosin.bellproject.view.ResultView;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class DataExceptionController {

    @ResponseBody
    @ExceptionHandler(value = DataBaseResultException.class)
    public Object handleDataBaseException(DataBaseResultException exception) {
        if(exception.getMessage() == null){
            return new ResultView("negative");
        }
        return new ErrorView(exception.getMessage(), 3111);
    }

    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handleArgumentException(MethodArgumentNotValidException exception){
        return new ErrorView("Переданы не все аргументы", 3108);
    }
}

















