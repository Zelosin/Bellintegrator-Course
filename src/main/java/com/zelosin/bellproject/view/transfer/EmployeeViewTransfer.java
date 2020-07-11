package com.zelosin.bellproject.view.transfer;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.filter.EmployeeViewFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeViewTransfer extends EmployeeViewFilter {

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
     * Дата документа
     */
    @JsonView({Transfer.DetailView.class})
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * Название гражданства
     */
    @JsonView({Transfer.DetailView.class})
    private Integer citizenshipName;

    public EmployeeViewTransfer(
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String firstName,
            @NotNull(groups = {Transfer.Save.class, Transfer.Filter.class, Transfer.Update.class}) Integer officeId,
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String position) {
        super(firstName, officeId, position);
    }
}
