package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.EmployeeViewFilter;
import com.zelosin.bellproject.view.transfer.EmployeeViewTransfer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class EmployeeController  extends AbstractBellController<EmployeeViewFilter, EmployeeViewTransfer, Employee> {
    protected EmployeeController(@Qualifier(value = "EMP_SER")
         BellService<EmployeeViewFilter, EmployeeViewTransfer, Employee> bellService) {
        super(bellService);
    }
}
