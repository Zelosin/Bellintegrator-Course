package com.zelosin.bellproject.service.organization;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("ORG_SER")
public class OrganizationServiceImpl extends AbstractBellService<Organization>{

    public OrganizationServiceImpl(@Qualifier(value = "ORG_REP") BellDao<Organization> organizationDao) {
        super(organizationDao);
    }
}
