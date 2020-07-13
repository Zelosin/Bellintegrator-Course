package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
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
    @JsonView({Transfer.ResultView.class})
    private String result;
}