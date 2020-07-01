package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "First_Name", nullable = false, length = 20)
    private String firstName;

    @Column(name = "Second_Name", nullable = false, length = 20)
    private String secondName;

    @Column(name = "Middle_Name", nullable = false, length = 20)
    private String middleName;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Is_Identified")
    private boolean isIdentified;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Position_Id")
    private Position position;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "Office_Id")
    private Office office;

    @OneToMany(
            mappedBy = "employee",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<Citizenship> citizenshipList = new ArrayList<>();

    @OneToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "Document_Id")
    private Document document;


    public synchronized void addCitizenship(Citizenship citizenship){
        citizenship.setEmployee(this);
        citizenshipList.add(citizenship);
    }
}
