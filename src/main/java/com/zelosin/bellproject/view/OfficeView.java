package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.model.Country;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.transfer.Transfer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class OfficeView {

    /**
     * Идентификатор
     */
    @NotNull(groups = {Transfer.Update.class})
    @Null(groups = {Transfer.Save.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private Integer id;

    /**
     * Название
     */
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private String name;

    /**
     * Телефон
     */
    @JsonView({Transfer.DetailView.class})
    private String phone;

    /**
     * Признак активности
     */
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private Boolean isActive;

    /**
     * Страна офиса
     */
    @JsonView({Transfer.DetailView.class})
    private Integer baseCountryCode;

    /**
     * Организация офиса
     */
    @NotNull(groups = {Transfer.Filter.class, Transfer.Save.class})
    private Integer orgId;

}
