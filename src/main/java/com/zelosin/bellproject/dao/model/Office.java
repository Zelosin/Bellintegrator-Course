package com.zelosin.bellproject.dao.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "Office")
public class Office {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "is_Active")
    private boolean isActive;

    @ManyToOne
    @JoinColumn(name = "office_country_id")
    private Country officeCountry;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "organization_id")
    private Organization organization;

}
