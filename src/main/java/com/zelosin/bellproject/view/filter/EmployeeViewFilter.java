package com.zelosin.bellproject.view.filter;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.IdentifiedView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * DTO-фильтр user'a
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeViewFilter extends IdentifiedView {

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
     * Офис сотрудника
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Filter.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private Integer officeId;

    /**
     * Должность
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    private String position;

    /**
     * Документ сотрудника
     */
    @JsonView({Transfer.DetailView.class})
    private Integer documentCode;

    /**
     * Код гражданства
     */
    @JsonView({Transfer.DetailView.class})
    private Integer citizenshipCode;

    public EmployeeViewFilter(@NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String firstName,
                              @NotNull(groups = {Transfer.Save.class, Transfer.Filter.class, Transfer.Update.class}) Integer officeId,
                              @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String position) {
        this.firstName = firstName;
        this.officeId = officeId;
        this.position = position;
    }
}