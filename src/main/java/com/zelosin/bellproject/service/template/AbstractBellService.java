package com.zelosin.bellproject.service.template;

import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.exception.DataBaseResultException;
import com.zelosin.bellproject.view.IdentifiedView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


/**
 * {@inheritDoc}
 */
@Service
public abstract class AbstractBellService<F, D extends IdentifiedView, E> implements BellService<F, D, E> {

    private final BellDao<F, D, E> bellDao;
    protected final MapperFactory orikaMapper;

    public AbstractBellService(BellDao<F, D, E> organizationDao, MapperFactory orikaMapper) {
        this.bellDao = organizationDao;
        this.orikaMapper = orikaMapper;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public D findById(int id) {
        E e = bellDao.findById(id);
        return getDTO(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void update(D d) {
        if(d == null){
            throw new DataBaseResultException("rejected", new NullPointerException());
        }
        bellDao.update(getEntity(d), d.getId());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void save(D d) {
        if(d == null){
            throw new DataBaseResultException("rejected", new NullPointerException());
        }
        bellDao.save(getEntity(d));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<D> getList(F f) {
        if(f == null){
            throw new DataBaseResultException("rejected", new NullPointerException());
        }
        List<E> e = bellDao.getList(f);
        return getDTOList(e);
    }
}