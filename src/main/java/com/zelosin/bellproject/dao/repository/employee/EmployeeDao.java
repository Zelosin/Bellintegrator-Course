package com.zelosin.bellproject.dao.repository.employee;

import com.zelosin.bellproject.dao.model.*;
import com.zelosin.bellproject.dao.repository.template.AbstractBellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.view.EmployeeView;
import com.zelosin.bellproject.view.OfficeView;
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

@Repository("EMP_REP")
public class EmployeeDao extends AbstractBellDao<EmployeeView, Employee> {

    protected EmployeeDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void update(Employee employee, int id) {
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
            if(primeEmployee.getCitizenship() == null){
                primeEmployee.setCitizenship(new Citizenship());
                primeEmployee.getCitizenship().setEmployee(primeEmployee);
            }
            primeEmployee.getCitizenship().setCitizenedCountry(employee.getCitizenship().getCitizenedCountry());
            primeEmployee.getCitizenship().setName(employee.getCitizenship().getName());
        }
    }

    @Override
    public void resolveInnerElementDependecy(Employee employee) {
        if(employee.getOffice() != null) {
            employee.setOffice(findOfficeById(employee.getOffice().getId()));
        }
        employee.setPosition(findPositionById(employee.getPosition().getId()));
        if(employee.getDocument() != null){
            employee.getDocument().setDocumentInfo(getDocumentTypeByCode(employee.getDocument().getDocumentInfo().getCode()));
            employee.getDocument().setEmployee(employee);
        }
        if(employee.getCitizenship() != null){
            employee.getCitizenship().setCitizenedCountry(getCountryByCode(employee.getCitizenship().getCitizenedCountry().getCode()));
        }
    }

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

    @Override
    public List<Employee> getList(EmployeeView employeeView) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> employeeRoot = criteriaQuery.from(Employee.class);
        criteriaQuery.select(employeeRoot);
        if(employeeView != null){
            Predicate filterPredicate = criteriaBuilder.equal(employeeRoot.get("office").get("id"), employeeView.getOfficeId());
            if(employeeView.getFirstName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("firstName"), employeeView.getFirstName()));
            }
            if(employeeView.getSecondName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("secondName"), employeeView.getSecondName()));
            }
            if(employeeView.getMiddleName() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("middleName"), employeeView.getMiddleName()));
            }
            if(employeeView.getPositionId() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("position").get("id"), employeeView.getPositionId()));
            }
            if(employeeView.getDocumentCode() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("document").get("documentInfo").get("code"), employeeView.getDocumentCode()));
            }
            if(employeeView.getCitizenshipCode() != null){
                filterPredicate  = criteriaBuilder.and(filterPredicate, criteriaBuilder.equal(
                        employeeRoot.get("citizenship").get("citizenedCountry").get("code"), employeeView.getCitizenshipCode()));
            }
            criteriaQuery.where(filterPredicate);
        }
        return new ArrayList<>(entityManager.createQuery(criteriaQuery).getResultList());
    }
}
