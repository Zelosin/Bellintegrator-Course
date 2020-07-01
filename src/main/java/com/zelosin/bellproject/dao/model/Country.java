package com.zelosin.bellproject.dao.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Country")
public class Country {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Code")
    private int code;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

}
