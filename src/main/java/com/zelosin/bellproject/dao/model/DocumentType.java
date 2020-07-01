package com.zelosin.bellproject.dao.model;


import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name", length = 45, nullable = false)
    private String name;

    @Column(name = "Code")
    private int code;

    @OneToMany(
            mappedBy = "documentInfo",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    private List<Document> documentList = new ArrayList<>();



    public synchronized void addDocument(Document document){
        document.setDocumentInfo(this);
        documentList.add(document);
    }

}
