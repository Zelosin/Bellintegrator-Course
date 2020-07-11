package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
import com.zelosin.bellproject.view.transfer.OrganizationViewTransfer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/organization")
public class OrganizationController extends AbstractBellController<OrganizationViewFilter, OrganizationViewTransfer, Organization> {

    protected OrganizationController(@Qualifier(value = "ORG_SER")
         BellService<OrganizationViewFilter, OrganizationViewTransfer, Organization> bellService) {
        super(bellService);
    }

}