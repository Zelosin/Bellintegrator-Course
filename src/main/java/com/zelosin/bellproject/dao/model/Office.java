package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import java.util.ArrayList;
import java.util.List;

/**
 * Entity-объект офиса
 */
@Data
@Entity
@Table(name = "Office")
public class Office {

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
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Признак активности
     */
    @Column(name = "is_Active")
    private Boolean isActive;

    /**
     * Страна офиса
     */
    @ManyToOne
    @JoinColumn(name = "office_country_id")
    private Country baseCountry;

    /**
     * Организация офиса
     */
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
        }, fetch = FetchType.LAZY
    )
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Список сотрудников
     */
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();
}