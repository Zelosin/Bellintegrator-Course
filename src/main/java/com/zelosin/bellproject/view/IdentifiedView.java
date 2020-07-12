package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Агрегационныый DTO для идентификации
 */
@Data
public class IdentifiedView {

    /**
     * Идентификатор
     */
    @NotNull(groups = {Transfer.Update.class})
    @Null(groups = {Transfer.Save.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    protected Integer id;
}