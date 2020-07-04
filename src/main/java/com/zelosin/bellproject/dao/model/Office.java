package com.zelosin.bellproject.dao.model;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Integer version;

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
    })
    @JoinColumn(name = "organization_id")
    private Organization organization;

    /**
     * Список должностей
     */
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Position> positionList = new ArrayList<>();

    /**
     * Список сотрудников
     */
    @OneToMany(mappedBy = "office", fetch = FetchType.LAZY)
    private List<Employee> employeeList = new ArrayList<>();

}
