package com.zelosin.bellproject.service.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.view.OfficeView;
import com.zelosin.bellproject.view.OrganizationView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OFC_SER")
public class OfficeServiceImpl extends AbstractBellService<OfficeView, Office> {
    public OfficeServiceImpl(@Qualifier(value = "OFC_REP") BellDao<OfficeView, Office> organizationDao, MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    @Override
    public OfficeView getDTO(Office office) {
        return orikaMapper.getMapperFacade().map(office, OfficeView.class);
    }

    @Override
    public Office getEntity(OfficeView officeView) {
        return orikaMapper.getMapperFacade().map(officeView, Office.class);
    }

    @Override
    public List<OfficeView> getDTOList(List<Office> offices) {
        return orikaMapper.getMapperFacade().mapAsList(offices, OfficeView.class);
    }
}
