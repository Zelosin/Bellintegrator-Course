package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity-объект стран
 */
@Data
@Entity
@Table(name = "Country")
public class Country {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version = 0;

    /**
     * Код
     */
    @Column(name = "code")
    private int code;

    /**
     * Название
     */
    @Column(name = "Name", length = 20, nullable = false)
    private String name;


}