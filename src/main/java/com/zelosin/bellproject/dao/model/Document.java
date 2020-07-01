package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Document")
public class Document {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   /* @Column(name = "Assign_Date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;*/

    @ManyToOne(
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
    })
    @JoinColumn(name = "Document_info_id")
    private DocumentType documentInfo;

    @OneToOne(
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            },
            mappedBy = "document"
    )
    private Employee employee;


}
