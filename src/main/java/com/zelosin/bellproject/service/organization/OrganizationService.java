package com.zelosin.bellproject.service.organization;

import com.zelosin.bellproject.dao.model.Organization;

import java.util.List;

public interface OrganizationService {

    Organization findOrgizationById(int id);
    void updateOrganization(Organization organization);
    void saveOrganization(Organization organization);
    List<Organization> getOrganizationList();

}
