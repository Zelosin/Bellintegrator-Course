package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Organization")
public class Organization {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", nullable = false, length = 20)
    private String name;

    @Column(name = "Full_Name", nullable = false, length = 45)
    private String fullName;

    @Column(name = "INN", length = 15)
    private long INN;

    @Column(name = "KPP", length = 15)
    private long KPP;

    @Column(name = "Address", length = 45)
    private String address;

    @Column(name = "Phone", length = 20)
    private String phone;

    @Column(name = "Is_Active")
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Base_Country_Id")
    private Country baseCountry;

    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Office> officeList = new ArrayList<>();

    public synchronized void addOffice(Office office){
        office.setOrganization(this);
        officeList.add(office);
    }

}
