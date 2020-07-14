package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import java.util.Date;

/**
 * Entity-объект документа
 */
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
    private Integer version = 0;

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
            }, fetch = FetchType.LAZY
    )
    @JoinColumn(name = "document_type")
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
            }, fetch = FetchType.LAZY
    )
    @JoinColumn(name = "employee_id")
    private Employee employee;
}