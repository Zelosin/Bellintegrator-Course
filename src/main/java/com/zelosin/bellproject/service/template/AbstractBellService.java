package com.zelosin.bellproject.service.template;

import com.zelosin.bellproject.dao.repository.template.BellDao;
import com.zelosin.bellproject.view.IdentifiedView;
import ma.glasnost.orika.MapperFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public abstract class AbstractBellService<F, D extends IdentifiedView, E> implements BellService<F, D, E> {

    private final BellDao<F, D, E> bellDao;
    protected final MapperFactory orikaMapper;

    public AbstractBellService(BellDao<F, D, E> organizationDao, MapperFactory orikaMapper) {
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
    public void update(D d) {
        bellDao.update(getEntity(d), d.getId());
    }

    @Override
    @Transactional
    public void save(D d) {
        bellDao.save(getEntity(d));
    }

    @Override
    @Transactional
    public List<D> getList(F f) {
        List<E> e = bellDao.getList(f);
        return getDTOList(e);
    }


    @Override
    public abstract D getDTO(E e);

    @Override
    public abstract E getEntity(D d);

    @Override
    public abstract List<D> getDTOList(List<E> eList);

}
