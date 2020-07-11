package com.zelosin.bellproject.service.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.view.filter.OfficeViewFilter;
import com.zelosin.bellproject.view.transfer.OfficeViewTransfer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("OFC_SER")
public class OfficeServiceImpl extends AbstractBellService<OfficeViewFilter, OfficeViewTransfer, Office> {
    public OfficeServiceImpl(@Qualifier(value = "OFC_REP") BellDao<OfficeViewFilter, OfficeViewTransfer, Office> organizationDao, MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    @Override
    public OfficeViewTransfer getDTO(Office office) {
        return orikaMapper.getMapperFacade().map(office, OfficeViewTransfer.class);
    }

    @Override
    public Office getEntity(OfficeViewTransfer officeView) {
        return orikaMapper.getMapperFacade().map(officeView, Office.class);
    }

    @Override
    public List<OfficeViewTransfer> getDTOList(List<Office> offices) {
        return orikaMapper.getMapperFacade().mapAsList(offices, OfficeViewTransfer.class);
    }
}
