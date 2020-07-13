package com.zelosin.bellproject.service.organization;

import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.InnerProgramException;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.view.filter.OrganizationViewFilter;
import com.zelosin.bellproject.view.transfer.OrganizationViewTransfer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service("ORG_SER")
public class OrganizationServiceImpl extends AbstractBellService<OrganizationViewFilter, OrganizationViewTransfer, Organization>{

    public OrganizationServiceImpl(@Qualifier(value = "ORG_REP") BellDao<OrganizationViewFilter, OrganizationViewTransfer, Organization> organizationDao, MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OrganizationViewTransfer getDTO(Organization organization) {
        if(organization == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().map(organization, OrganizationViewTransfer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization getEntity(OrganizationViewTransfer organizationView) {
        if(organizationView == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().map(organizationView, Organization.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OrganizationViewTransfer> getDTOList(List<Organization> organizations) {
        if(organizations == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().mapAsList(organizations, OrganizationViewTransfer.class);
    }
}