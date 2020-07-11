package com.zelosin.bellproject.service;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.OfficeViewFilter;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
import com.zelosin.bellproject.view.transfer.OfficeViewTransfer;
import com.zelosin.bellproject.view.transfer.OrganizationViewTransfer;
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
class OfficeServiceTest {

	@Autowired
	@Qualifier(value = "OFC_SER")
	BellService<OfficeViewFilter, OfficeViewTransfer, Office> bellOfficeService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	OfficeViewTransfer createTransferObject(String uuidString){
		return new OfficeViewTransfer(
				uuidString,
				"+7",
				true,
				1,
				250
		);
	}

	@Test
	void getElementListTest() {
		String organizationName = UUID.randomUUID().toString().substring(0, 20);
		OfficeViewTransfer officeViewTransfer = createTransferObject(organizationName);

		OfficeViewFilter officeViewFilter = new OfficeViewFilter(
				organizationName,
				null,
				null,
				1
		);

		bellOfficeService.save(officeViewTransfer);

		List<OfficeViewTransfer> officeViewTransferList;
		officeViewTransferList = bellOfficeService.getList(officeViewFilter);

		Assert.assertNotEquals(officeViewTransferList.size(), 0);
	}

	@Test
	void saveTest_NonUnicElement() {
		String organizationName = UUID.randomUUID().toString().substring(0, 20);
		OfficeViewTransfer officeViewTransfer = createTransferObject(organizationName);

		exception.expect(DataBaseResultException.class);
		OfficeViewTransfer officeOrganizationViewTransfer = officeViewTransfer;
		bellOfficeService.save(officeOrganizationViewTransfer);
	}


	@Test
	void updateTest(){
		Integer testedElementId = 1;

		String newOrganizationName = UUID.randomUUID().toString().substring(0, 20);
		OfficeViewTransfer officeViewTransfer = createTransferObject(newOrganizationName);
		officeViewTransfer.setId(testedElementId);

		bellOfficeService.update(officeViewTransfer);
		OfficeViewTransfer dataBaseElement = bellOfficeService.findById(testedElementId);

		Assert.assertEquals(officeViewTransfer, dataBaseElement);
	}

}
