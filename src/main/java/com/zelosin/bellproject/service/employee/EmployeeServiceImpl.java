package com.zelosin.bellproject.service.employee;

import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.view.EmployeeView;
import com.zelosin.bellproject.view.OfficeView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EMP_SER")
public class EmployeeServiceImpl extends AbstractBellService<EmployeeView, Employee> {
    public EmployeeServiceImpl(
            @Qualifier ("EMP_REP") BellDao<EmployeeView, Employee> organizationDao,
            MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    @Override
    public EmployeeView getDTO(Employee employee) {
        return orikaMapper.getMapperFacade().map(employee, EmployeeView.class);
    }

    @Override
    public Employee getEntity(EmployeeView employeeView) {
        return orikaMapper.getMapperFacade().map(employeeView, Employee.class);
    }

    @Override
    public List<EmployeeView> getDTOList(List<Employee> employees) {
        return orikaMapper.getMapperFacade().mapAsList(employees, EmployeeView.class);
    }
}
