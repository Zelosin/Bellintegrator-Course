package com.zelosin.bellproject.service.employee;

import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.view.filter.EmployeeViewFilter;
import com.zelosin.bellproject.view.transfer.EmployeeViewTransfer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("EMP_SER")
public class EmployeeServiceImpl extends AbstractBellService<EmployeeViewFilter, EmployeeViewTransfer, Employee> {
    public EmployeeServiceImpl(
            @Qualifier ("EMP_REP") BellDao<EmployeeViewFilter, EmployeeViewTransfer, Employee> organizationDao,
            MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    @Override
    public EmployeeViewTransfer getDTO(Employee employee) {
        return orikaMapper.getMapperFacade().map(employee, EmployeeViewTransfer.class);
    }

    @Override
    public Employee getEntity(EmployeeViewTransfer employeeView) {
        return orikaMapper.getMapperFacade().map(employeeView, Employee.class);
    }

    @Override
    public List<EmployeeViewTransfer> getDTOList(List<Employee> employees) {
        return orikaMapper.getMapperFacade().mapAsList(employees, EmployeeViewTransfer.class);
    }
}
