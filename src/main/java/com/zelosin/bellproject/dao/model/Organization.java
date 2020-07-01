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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Column(name = "full_name", nullable = false, length = 45)
    private String fullName;

    @Column(name = "inn", length = 15)
    private long INN;

    @Column(name = "kpp", length = 15)
    private long KPP;

    @Column(name = "address", length = 45)
    private String address;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "is_active")
    private boolean isActive;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "base_country_id")
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
