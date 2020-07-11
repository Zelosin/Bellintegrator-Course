package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.OfficeViewFilter;
import com.zelosin.bellproject.view.transfer.OfficeViewTransfer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/office")
public class OfficeController  extends AbstractBellController<OfficeViewFilter, OfficeViewTransfer, Office> {
    protected OfficeController(@Qualifier(value = "OFC_SER")
                                       BellService<OfficeViewFilter, OfficeViewTransfer, Office> bellService) {
        super(bellService);
    }
}
