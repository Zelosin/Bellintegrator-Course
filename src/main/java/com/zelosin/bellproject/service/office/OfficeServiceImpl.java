package com.zelosin.bellproject.service.office;

import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.service.template.AbstractBellService;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("OFC_SER")
public class OfficeServiceImpl extends AbstractBellService<Office> {
    public OfficeServiceImpl(@Qualifier(value = "OFC_REP") BellDao<Office> organizationDao) {
        super(organizationDao);
    }
}
