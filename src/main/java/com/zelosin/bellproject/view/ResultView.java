package com.zelosin.bellproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO результата обновления\сохранения объекта в базе данных
 */
@Data
@AllArgsConstructor
public class ResultView {

    /**
     * Результат
     */
    private String result;
}