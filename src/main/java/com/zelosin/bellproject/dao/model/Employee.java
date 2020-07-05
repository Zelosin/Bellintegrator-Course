package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

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
     * Имя
     */
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;

    /**
     * Фамилия
     */
    @Column(name = "second_name", nullable = false, length = 20)
    private String secondName;

    /**
     * Отчество
     */
    @Column(name = "middle_name", nullable = false, length = 20)
    private String middleName;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Признак идентифицированности
     */
    @Column(name = "is_identified")
    private boolean isIdentified;

    /**
     * Должность
     */
    @OneToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "position_id")
    private Position position;

    /**
     * Офис сотрудника
     */
    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "office_id")
    private Office office;

    /**
     * Список граждаств сотрудника
     */
    @OneToOne(mappedBy = "employee")
    private Citizenship citizenship;

    /**
     * Документ сотрудника
     */
    @OneToOne(
            cascade = CascadeType.ALL,
            mappedBy = "employee"
    )
    private Document document;

}
