package com.zelosin.bellproject.service.template;

import java.util.List;

/**
 * Интерфейс сервис-уроней приложения
 * @param <F>  DTO-фильтр
 * @param <D>  DTO-трансфера
 * @param <E>  Entity-ебъект
 */
public interface BellService<F, D, E> {

    /**
     * Получение DTO-объекта из Entity-объкта
     * @param e Entity-объект
     * @return DTO-объект
     */
    D getDTO(E e);

    /**
     * Получение Entity-объкта из DTO-объекта
     * @param d DTO-объект
     * @return Entity-объект
     */
    E getEntity(D d);

    /**
     * Получение списка DTO-объектов из списка Entity-объектов
     * @param eList список Entity-объектов
     * @return список DTO-объектов
     */
    List<D> getDTOList(List<E> eList);

    /**
     * Поиск объекта по идентификатору, при ошибке - прерывание и DTO-объект ошибки
     * @param id идентификатор
     * @return DTO-объекта из базы данных
     */
    D findById(int id);

    /**
     * Обновление объекта в базе данных, при ошибке - прерывание и DTO-объект ошибки
     * @param d  DTO-объект для обновления
     */
    void update(D d);

    /**
     * Сохранение DTO-объекта, при ошибке - прерывание и DTO-объект ошибки
     * @param d  DTO-объект для сохранения
     */
    void save(D d);

    /**
     * Получение списка объектов из базы данных по фильтру, при ошибке - прерывание и DTO-объект ошибки
     * @param f  DTO-фильтр
     * @return  список DTO-объектов
     */
    List<D> getList(F f);
}