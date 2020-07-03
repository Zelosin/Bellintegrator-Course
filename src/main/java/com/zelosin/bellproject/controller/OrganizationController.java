package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.transfer.Transfer;
import com.zelosin.bellproject.service.template.BellService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;


@RestController
@RequestMapping("/api/organization")
public class OrganizationController extends AbstractBellController<Organization> {

    protected OrganizationController(@Qualifier(value = "ORG_SER") BellService<Organization> bellService) {
        super(bellService);
    }

    @Override
    @PostMapping("/update")
    public Map updateElement(@Validated(Transfer.Update.class)  @RequestBody Organization organization) {
        bellService.update(organization, organization.getId());
        return Collections.singletonMap("result", "success");
    }
}