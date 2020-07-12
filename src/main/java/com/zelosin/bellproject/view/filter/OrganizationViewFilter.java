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
 * DTO-фильтр организации
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationViewFilter extends IdentifiedView {

    /**
     * Название
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class, Transfer.Filter.class})
    @JsonView({Transfer.ListView.class})
    private String name;

    /**
     * ИНН
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private Long INN;

    /**
     * Признак активности
     */
    @JsonView({Transfer.ListView.class})
    private Boolean isActive;
}