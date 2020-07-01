package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Document_Type")
public class DocumentType {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * Название
     */
    @Column(name = "name", length = 45, nullable = false)
    private String name;

    /**
     * Код
     */
    @Column(name = "code")
    private int code;

    /**
     * Список типовых документов
     */
    @OneToMany(
            mappedBy = "documentInfo",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Document> documentList = new ArrayList<>();

    /**
     * Добавление типового документа в список
     * @param document - типовой документ
     */
    public synchronized void addDocument(Document document){
        document.setDocumentInfo(this);
        documentList.add(document);
    }

}
