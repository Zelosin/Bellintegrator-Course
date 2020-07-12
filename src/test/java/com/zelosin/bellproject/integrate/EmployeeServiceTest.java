package com.zelosin.bellproject.integrate;

import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.EmployeeViewFilter;
import com.zelosin.bellproject.view.transfer.EmployeeViewTransfer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
class EmployeeServiceTest {

	@Autowired
	@Qualifier(value = "EMP_SER")
	BellService<EmployeeViewFilter, EmployeeViewTransfer, Employee> bellEmployeeService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	EmployeeViewTransfer createTransferObject(String uuidString){
		return new EmployeeViewTransfer(
				uuidString,
				1,
				uuidString.toUpperCase()
		);
	}

	@Test
	void getElementListTest() {
		String employeeName = UUID.randomUUID().toString().substring(0, 20);
		EmployeeViewTransfer employeeViewTransfer = createTransferObject(employeeName);

		EmployeeViewFilter officeViewFilter = new EmployeeViewFilter(
				employeeName,
				1,
				null
		);

		bellEmployeeService.save(employeeViewTransfer);

		List<EmployeeViewTransfer> employeeViewTransferList;
		employeeViewTransferList = bellEmployeeService.getList(officeViewFilter);

		Assert.assertNotEquals(employeeViewTransferList.size(), 0);
	}


	@Test
	void updateTest(){
		Integer testedElementId = 2;

		String employeeName = UUID.randomUUID().toString().substring(0, 20);
		EmployeeViewTransfer employeeViewTransfer = createTransferObject(employeeName);
		employeeViewTransfer.setId(testedElementId);

		bellEmployeeService.update(employeeViewTransfer);
		EmployeeViewTransfer dataBaseElement = bellEmployeeService.findById(testedElementId);
		Assert.assertEquals(employeeViewTransfer.getFirstName(), dataBaseElement.getFirstName());
	}
}