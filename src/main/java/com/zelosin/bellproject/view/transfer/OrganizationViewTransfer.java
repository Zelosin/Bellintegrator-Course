package com.zelosin.bellproject.view.transfer;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * DTO организации
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationViewTransfer extends OrganizationViewFilter {

    /**
     * Полное название
     */
    @NotNull(groups = {Transfer.Save.class, Transfer.Update.class})
    @JsonView({Transfer.DetailView.class})
    private String fullName;

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
     * Страна организации
     */
    @JsonView({Transfer.DetailView.class})
    private Integer baseCountryCode;

    public OrganizationViewTransfer(
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class, Transfer.Filter.class}) String name,
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String fullName,
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) Long INN,
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) Long KPP,
            @NotNull(groups = {Transfer.Save.class, Transfer.Update.class}) String address,
            Boolean isActive,
            Integer baseCountryCode) {
        super(name, INN, isActive);
        this.fullName = fullName;
        this.KPP = KPP;
        this.address = address;
        this.phone = phone;
        this.baseCountryCode = baseCountryCode;
    }
}