package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO данных, возвращаемых контроллерами
 */
@Data
@AllArgsConstructor
public class DataView {

    /**
     * Данные
     */
    @JsonView({Transfer.DetailView.class, Transfer.ListView.class})
    private Object data;
}