package com.zelosin.bellproject.view;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.model.Citizenship;
import com.zelosin.bellproject.dao.model.Document;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.model.Position;
import com.zelosin.bellproject.dao.transfer.Transfer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EmployeeView {

    /**
     * Идентификатор
     */
    @NotNull(groups = {Transfer.Update.class})
    @Null(groups = {Transfer.Save.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private Integer id;

    /**
     * Имя
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private String firstName;

    /**
     * Фамилия
     */
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private String secondName;

    /**
     * Отчество
     */
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private String middleName;

    /**
     * Телефон
     */
    @JsonView({Transfer.DetailView.class})
    private String phone;

    /**
     * Признак идентифицированности
     */
    @JsonView({Transfer.DetailView.class})
    private boolean isIdentified;

    /**
     * Должность
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private Integer positionId;

    /**
     * Офис сотрудника
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.ListView.class})
    @JsonView({Transfer.DetailView.class})
    private Integer officeId;

    /**
     * Документ сотрудника
     */
    @JsonView({Transfer.DetailView.class})
    private Integer documentCode;

    /**
     * Дата документа
     */
    @JsonView({Transfer.DetailView.class})
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * Код гражданства
     */
    @JsonView({Transfer.DetailView.class})
    private Integer citizenshipCode;

    /**
     * Название гражданства
     */
    @JsonView({Transfer.DetailView.class})
    private Integer citizenshipName;

}
