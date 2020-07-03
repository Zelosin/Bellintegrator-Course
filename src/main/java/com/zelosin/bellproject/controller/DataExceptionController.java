package com.zelosin.bellproject.controller;


import com.zelosin.bellproject.exception.DataBaseResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice
public class DataExceptionController {

    @ExceptionHandler(value = DataBaseResultException.class)
    public ResponseEntity<Object> handleDataBaseException(DataBaseResultException exception) {
        if(exception.getMessage() == null)
            return new ResponseEntity<>(Collections.singletonMap("result","negative"), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(Collections.singletonMap("error",exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleArgumentException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>(Collections.singletonMap("error", "Переданы не все аргументы"), HttpStatus.BAD_REQUEST);
    }

}

















