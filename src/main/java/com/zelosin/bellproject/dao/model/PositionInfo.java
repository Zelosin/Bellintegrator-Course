package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Employee_Position_Info")
public class PositionInfo {

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
     * Название должности
     */
    @Column(name = "Name", length = 30, nullable = false)
    private String name;

}
