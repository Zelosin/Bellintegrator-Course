package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


/**
 * Entity-объект гражданства
 */
@Data
@Entity
@Table(name = "Citizenship")
public class Citizenship {

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
     * Название
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * Страна гражданства
     */
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "citizenship_country_id")
    private Country citizenedCountry;

}