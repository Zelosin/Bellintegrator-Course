package com.zelosin.bellproject.service.organization;

import com.zelosin.bellproject.dao.mapper.OrikaMapper;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.view.OrganizationView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ORG_SER")
public class OrganizationServiceImpl extends AbstractBellService<OrganizationView, Organization>{

    public OrganizationServiceImpl(@Qualifier(value = "ORG_REP") BellDao<OrganizationView, Organization> organizationDao, MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    @Override
    public OrganizationView getDTO(Organization organization) {
        return orikaMapper.getMapperFacade().map(organization, OrganizationView.class);
    }

    @Override
    public Organization getEntity(OrganizationView organizationView) {
        return orikaMapper.getMapperFacade().map(organizationView, Organization.class);
    }

    @Override
    public List<OrganizationView> getDTOList(List<Organization> organizations) {
        return orikaMapper.getMapperFacade().mapAsList(organizations, OrganizationView.class);
    }
}
