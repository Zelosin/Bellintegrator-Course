package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.*;

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
