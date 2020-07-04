package com.zelosin.bellproject.service.template;

import com.zelosin.bellproject.dao.model.Organization;
import java.util.List;

public interface BellService<D, E> {

    D getDTO(E e);
    E getEntity(D d);
    List<D> getDTOList(List<E> eList);

    D findById(int id);
    void update(D d, int id);
    void save(D d);
    List<D> getList(D d);

}
