package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Citizenship")
public class Citizenship {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Citizenship_Country_Id")
    private Country citizenedCountry;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Employee_Id")
    private Employee employee;

}

















