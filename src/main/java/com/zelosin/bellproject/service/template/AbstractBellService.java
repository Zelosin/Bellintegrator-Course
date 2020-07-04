package com.zelosin.bellproject.service.template;

import com.zelosin.bellproject.dao.mapper.OrikaMapper;
import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.service.template.BellService;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public abstract class AbstractBellService<D, E> implements BellService<D, E> {

    private final BellDao<D, E> bellDao;
    protected final MapperFactory orikaMapper;

    public AbstractBellService(BellDao<D, E> organizationDao, MapperFactory orikaMapper) {
        this.bellDao = organizationDao;
        this.orikaMapper = orikaMapper;
    }

    @Override
    @Transactional
    public D findById(int id) {
        E e = bellDao.findById(id);
        return getDTO(e);
    }

    @Override
    @Transactional
    public void update(D d, int id) {
        bellDao.update(getEntity(d), id);
    }

    @Override
    @Transactional
    public void save(D d) {
        bellDao.save(getEntity(d));
    }

    @Override
    @Transactional
    public List<D> getList(D d) {
        List<E> e = bellDao.getList(d);
        return getDTOList(e);
    }
}
