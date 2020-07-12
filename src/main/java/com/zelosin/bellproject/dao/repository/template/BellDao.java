package com.zelosin.bellproject.dao.repository.template;

import java.util.List;


/**
 * Интерфейс DAO-уроней приложения
 * @param <F>  DTO-фильтр
 * @param <D>  DTO-трансфера
 * @param <E>  Entity-ебъект
 */
public interface BellDao<F, D, E> {

    /**
     * Разрешение внутренних зависимостей Entity-объекта
     * @param e  Entity-объект
     */
    void resolveInnerElementDependecy(E e);

    /**
     * Поиск объекта по идентификатору, при ошибке - прерывание и DTO-объект ошибки
     * @param id идентификатор
     * @return  объект из базы данных
     */
    E findById(int id);

    /**
     * Обновление объекта в базе данных, при ошибке - прерывание и DTO-объект ошибки
     * @param e  Enity-объект для обновления
     * @param id  идентификатор Enity-объекта
     */
    void update(E e, int id);

    /**
     * Сохранение Entity-объекта, при ошибке - прерывание и DTO-объект ошибки
     * @param e  Entity-объект для сохранения
     */
    void save(E e);

    /**
     * Получение списка объектов из базы данных по фильтру, при ошибке - прерывание и DTO-объект ошибки
     * @param f  DTO-фильтр
     * @return  список объектов
     */
    List<E> getList(F f);
}