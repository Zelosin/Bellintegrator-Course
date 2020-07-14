package com.zelosin.bellproject.service.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.InnerProgramException;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.view.filter.OfficeViewFilter;
import com.zelosin.bellproject.view.transfer.OfficeViewTransfer;
import ma.glasnost.orika.MapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service("OFC_SER")
public class OfficeServiceImpl extends AbstractBellService<OfficeViewFilter, OfficeViewTransfer, Office> {
    public OfficeServiceImpl(@Qualifier(value = "OFC_REP") BellDao<OfficeViewFilter, OfficeViewTransfer, Office> organizationDao, MapperFactory orikaMapper) {
        super(organizationDao, orikaMapper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OfficeViewTransfer getDTO(Office office) {
        if(office == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().map(office, OfficeViewTransfer.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Office getEntity(OfficeViewTransfer officeView) {
        if(officeView == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().map(officeView, Office.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<OfficeViewTransfer> getDTOList(List<Office> offices) {
        if(offices == null){
            throw new InnerProgramException( new NullPointerException());
        }
        return orikaMapper.getMapperFacade().mapAsList(offices, OfficeViewTransfer.class);
    }
}