package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;

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
    private Integer version;

    /**
     * Название
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * Страна гражданства
     */
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "citizenship_country_id")
    private Country citizenedCountry;

    /**
     * Сотрудник, которому принадлежит гражданство
     */
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "employee_id")
    private Employee employee;

}

















