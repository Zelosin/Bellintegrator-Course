package com.zelosin.bellproject.service.template;

import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.service.template.BellService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public abstract class AbstractBellService<D> implements BellService<D> {

    private final BellDao<D> bellDao;

    public AbstractBellService(BellDao<D> organizationDao) {
        this.bellDao = organizationDao;
    }

    @Override
    @Transactional
    public D findById(int id) {
        D dataBaseOrganization = bellDao.findById(id);
        if(dataBaseOrganization == null){
            throw new DataBaseResultException("Элемент не найден");
        }
        return dataBaseOrganization;
    }

    @Override
    @Transactional
    public void update(D d, int id) {
        bellDao.update(d, id);
    }

    @Override
    @Transactional
    public void save(D d) {
        bellDao.save(d);
    }

    @Override
    @Transactional
    public List<D> getList() {
        return bellDao.getList();
    }
}
