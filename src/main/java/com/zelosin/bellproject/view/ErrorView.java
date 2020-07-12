package com.zelosin.bellproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO ошибки
 */
@Data
@AllArgsConstructor
public class ErrorView {

    /**
     * Текст ошибки
     */
    private String error;
    /**
     * Код ошибки
     */
    private Integer code;
}