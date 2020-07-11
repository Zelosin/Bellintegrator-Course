package com.zelosin.bellproject.view;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorView {

    private String error;
    private Integer code;

}
