package com.zelosin.bellproject.util;

/**
 * Утильный класс для опредения типов валидации
 */
public class Transfer {

    /**
     * Валидация при сохранении
     */
    public interface Save{}

    /**
     * Валидация при обновлении
     */
    public interface Update{}

    /**
     * Валидация при фильтрации
     */
    public interface Filter{}

    /**
     * Валидация при списочном отображении
     */
    public interface ListView{}

    /**
     * Валидация при детальном отображении
     */
    public interface DetailView extends ListView{};


    /**
     * Результат
     */
    public interface ResultView{};
}