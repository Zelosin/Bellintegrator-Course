package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.transfer.Transfer;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
public class OrganizationView {

    /**
     * Идентификатор
     */
    @NotNull(groups = {Transfer.Update.class, Transfer.ListView.class})
    @Null(groups = {Transfer.Save.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private Integer id;

    /**
     * Название
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class, Transfer.Filter.class})
    @JsonView({Transfer.ListView.class})
    private String name;

    /**
     * Полное название
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private String fullName;

    /**
     * ИНН
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private Long INN;

    /**
     * КПП
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private Long KPP;

    /**
     * Адрес
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private String address;

    /**
     * Телефон
     */
    @JsonView({Transfer.DetailView.class})
    private String phone;

    /**
     * Признак активности
     */
    @JsonView({Transfer.ListView.class})
    private Boolean isActive;

    /**
     * Страна организации
     */
    @JsonView({Transfer.DetailView.class})
    private Integer baseCountryCode;

}
