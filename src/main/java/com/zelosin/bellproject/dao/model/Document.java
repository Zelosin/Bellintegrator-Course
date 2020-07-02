package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "Document")
public class Document {

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
     * Дата удостоверения
     */
    @Column(name = "assign_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    /**
     * Описание документа
     */
    @ManyToOne(
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
    })
    @JoinColumn(name = "document_type_id")
    private DocumentType documentInfo;

    /**
     * Сотрудник, к которму привязан документ
     */
    @OneToOne(
            cascade = {
                CascadeType.DETACH,
                CascadeType.MERGE,
                CascadeType.PERSIST,
                CascadeType.REFRESH
            }
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
