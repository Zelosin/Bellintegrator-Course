package com.zelosin.bellproject.view.filter;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.IdentifiedView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OfficeViewFilter extends IdentifiedView {

    /**
     * Название
     */
    @JsonView({Transfer.ListView.class, Transfer.DetailView.class})
    @NotNull(groups = {Transfer.Update.class})
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
     * Организация офиса
     */
    @NotNull(groups = {Transfer.Filter.class, Transfer.Save.class})
    private Integer orgId;

}
