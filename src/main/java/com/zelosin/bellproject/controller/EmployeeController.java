package com.zelosin.bellproject.controller;

import com.zelosin.bellproject.controller.template.AbstractBellController;
import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.EmployeeView;
import com.zelosin.bellproject.view.OfficeView;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class EmployeeController  extends AbstractBellController<EmployeeView, Employee> {
    protected EmployeeController(@Qualifier(value = "EMP_SER") BellService<EmployeeView, Employee> bellService) {
        super(bellService);
    }

    @Override
    @PostMapping("/update")
    public Map updateElement(EmployeeView employeeView) {
        bellService.update(employeeView, employeeView.getId());
        return Collections.singletonMap("result", "success");
    }
}
