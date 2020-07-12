package com.zelosin.bellproject.view.transfer;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import com.zelosin.bellproject.view.filter.OfficeViewFilter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * DTO офиса
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class OfficeViewTransfer extends OfficeViewFilter {

    /**
     * Страна офиса
     */
    @JsonView({Transfer.DetailView.class})
    @NotNull(groups = {Transfer.Update.class})
    private Integer baseCountryCode;

    public OfficeViewTransfer(@NotNull(groups = {Transfer.Update.class}) String name,
                              String phone, Boolean isActive,
                              @NotNull(groups = {Transfer.Filter.class, Transfer.Save.class}) Integer orgId,
                              @NotNull(groups = {Transfer.Update.class}) Integer baseCountryCode) {
        super(name, phone, isActive, orgId);
        this.baseCountryCode = baseCountryCode;
    }
}