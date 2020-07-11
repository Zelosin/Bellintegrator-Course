package com.zelosin.bellproject.dao.repository.template;

import java.util.List;

public interface BellDao<F, D, E> {

    void resolveInnerElementDependecy(E e);
    E findById(int id);
    void update(E e, int id);
    void save(E e);
    List<E> getList(F f);

}
