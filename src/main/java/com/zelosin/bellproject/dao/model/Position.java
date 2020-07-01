package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Position")
public class Position {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

}
