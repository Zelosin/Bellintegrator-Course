package com.zelosin.bellproject.dao.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Office")
public class Office {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 20, nullable = false)
    private String name;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Is_Active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "Office_Country_Id")
    private Country officeCountry;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Organization_Id")
    private Organization organization;

}
