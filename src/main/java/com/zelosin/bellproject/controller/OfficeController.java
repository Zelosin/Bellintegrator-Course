package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.transfer.Transfer;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.OfficeView;
import com.zelosin.bellproject.view.OrganizationView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/office")
public class OfficeController  extends AbstractBellController<OfficeView, Office> {
    protected OfficeController(@Qualifier(value = "OFC_SER") BellService<OfficeView, Office> bellService) {
        super(bellService);
    }

    @Override
    @PostMapping("/update")
    public Map updateElement(@Validated(Transfer.Update.class) OfficeView officeView) {
        bellService.update(officeView, officeView.getId());
        return Collections.singletonMap("result", "success");
    }
}
