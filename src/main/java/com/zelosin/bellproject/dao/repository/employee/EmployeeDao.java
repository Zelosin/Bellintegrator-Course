package com.zelosin.bellproject.dao.repository.employee;

<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
import com.zelosin.bellproject.dao.model.Citizenship;
import com.zelosin.bellproject.dao.model.Country;
>>>>>>> 53e6dc6dc7538fc13674a77d6da1d81cf1d13bda
>>>>>>> cf24eb16aa0877ccc9e1c1c5a9ebdc079dedb3b5
import com.zelosin.bellproject.dao.model.Document;
import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.exception.InnerProgramException;
import com.zelosin.bellproject.view.filter.EmployeeViewFilter;
import com.zelosin.bellproject.view.transfer.EmployeeViewTransfer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * {@inheritDoc}
 */
@Repository("EMP_REP")
public class EmployeeDao extends AbstractBellDao<EmployeeViewFilter, EmployeeViewTransfer, Employee> {

    protected EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void update(Employee employee, int id) {
        if(employee == null){
            throw new InnerProgramException("Произошла внутреняя ошибка приложения", new NullPointerException());
        }
        Employee primeEmployee = findById(id);

        resolveInnerElementDependecy(employee);
        BeanUtils.copyProperties(employee, primeEmployee, "id", "version", "document", "citizenship");
        if(employee.getDocument() != null) {
            if(primeEmployee.getDocument() == null){
                primeEmployee.setDocument(new Document());
                primeEmployee.getDocument().setEmployee(primeEmployee);
            }
            primeEmployee.getDocument().setDocumentInfo(employee.getDocument().getDocumentInfo());
            primeEmployee.getDocument().setDate(employee.getDocument().getDate());
        }
        if(employee.getCitizenship() != null){
            if(primeEmployee.getCitizenship() != null){
                primeEmployee.getCitizenship().setCitizenedCountry(employee.getCitizenship().getCitizenedCountry());
                primeEmployee.getCitizenship().setName(employee.getCitizenship().getName());
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void resolveInnerElementDependecy(Employee employee) {
        if(employee == null){
            throw new InnerProgramException("Произошла внутреняя ошибка приложения", new NullPointerException());
        }
        if(employee.getOffice() != null) {
            employee.setOffice(findOfficeById(employee.getOffice().getId()));
        }
        if(employee.getCitizenship() != null){
            employee.setCitizenship(
                getCitizenshipByCountry(getCountryByCode(employee.getCitizenship().getCitizenedCountry().getCode())));
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Employee findById(int id) {
        Employee employee;
        TypedQuery<Employee> employeeTypedQuery = entityManager.createQuery("SELECT d FROM Employee d WHERE d.id=:empId", Employee.class);
        employeeTypedQuery.setParameter("empId", id);
        try {
            employee = employeeTypedQuery.getSingleResult();
        }catch (NoResultException e){
            throw new DataBaseResultException("Указан несуществующий код работника", e);
        }
        return employee;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Employee> getList(EmployeeViewFilter employeeViewFilter) {
        if(employeeViewFilter == null){
            throw new InnerProgramException( new NullPointerException());
        }
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);
        if(employeeViewFilter != null){
            Predicate filterPredicate = criteriaBuilder.equal(employeeRoot.get("office").get("id"), employeeViewFilter.getOfficeId());
            if(employeeViewFilter.getFirstName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("firstName"), employeeViewFilter.getFirstName()));
            }
            if(employeeViewFilter.getSecondName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("secondName"), employeeViewFilter.getSecondName()));
            }
            if(employeeViewFilter.getMiddleName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("middleName"), employeeViewFilter.getMiddleName()));
            }
            if(employeeViewFilter.getPosition() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("position"), employeeViewFilter.getPosition()));
            }
            if(employeeViewFilter.getDocCode() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("document").get("documentInfo").get("code"), employeeViewFilter.getDocCode()));
            }
            if(employeeViewFilter.getCitizenshipCode() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("citizenship").get("citizenedCountry").get("code"), employeeViewFilter.getCitizenshipCode()));
            }
            criteriaQuery.where(filterPredicate);
        }
        return new ArrayList<>(entityManager.createQuery(criteriaQuery).getResultList());
    }
}