package com.zelosin.bellproject.integrate;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.service.template.BellService;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
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
class OrganizationServiceTest {

	@Autowired
	@Qualifier(value = "ORG_SER")
	BellService<OrganizationViewFilter, OrganizationViewTransfer, Organization> bellOrganizationService;

	@Rule
	public final ExpectedException exception = ExpectedException.none();

	OrganizationViewTransfer createTransferObject(String uuidString){
		return new OrganizationViewTransfer(
				uuidString,
				uuidString.toUpperCase(),
				(long) 0,
				(long) 0,
				"testAddress",
				true,
				250
		);
	}

	@Test
	void getElementListTest() {
		String organizationName = UUID.randomUUID().toString().substring(0, 20);
		OrganizationViewTransfer organizationViewTransfer = createTransferObject(organizationName);

		OrganizationViewFilter organizationViewFilter = new OrganizationViewFilter(
				organizationName,
				null,
				null
		);

		bellOrganizationService.save(organizationViewTransfer);

		List<OrganizationViewTransfer> organizations;
		organizations = bellOrganizationService.getList(organizationViewFilter);

		Assert.assertNotEquals(organizations.size(), 0);
	}

	@Test
	void saveTest_NonUnicElementByCoupleOfNameAndFullName() {
		String organizationName = UUID.randomUUID().toString().substring(0, 20);
		OrganizationViewTransfer organizationViewTransfer = createTransferObject(organizationName);

		exception.expect(DataBaseResultException.class);
		OrganizationViewTransfer mimicOrganizationViewTransfer = organizationViewTransfer;
		bellOrganizationService.save(mimicOrganizationViewTransfer);
	}

	@Test
	void saveTest_NonUnicElementByCoupleOfINNAndKPP() {
		String organizationName = UUID.randomUUID().toString().substring(0, 20);
		OrganizationViewTransfer organizationViewTransfer = createTransferObject(organizationName);
		String mimicOrganizationName = UUID.randomUUID().toString().substring(0, 20);
		OrganizationViewTransfer mimicOrganizationViewTransfer = createTransferObject(mimicOrganizationName);
		Long KPP = 99999999L;
		Long INN = 99999999L;

		organizationViewTransfer.setINN(INN);
		organizationViewTransfer.setKPP(KPP);

		mimicOrganizationViewTransfer.setINN(INN);
		mimicOrganizationViewTransfer.setKPP(KPP);

		exception.expect(DataBaseResultException.class);
		bellOrganizationService.save(mimicOrganizationViewTransfer);
	}

	@Test
	void updateTest(){
		Integer testedElementId = 1;

		String newOrganizationName = UUID.randomUUID().toString().substring(0, 20);
		OrganizationViewTransfer organizationViewTransfer = createTransferObject(newOrganizationName);
		organizationViewTransfer.setId(testedElementId);

		bellOrganizationService.update(organizationViewTransfer);
		OrganizationViewTransfer dataBaseElement = bellOrganizationService.findById(testedElementId);

		Assert.assertEquals(organizationViewTransfer, dataBaseElement);
	}
}