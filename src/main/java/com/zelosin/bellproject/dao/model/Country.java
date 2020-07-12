package com.zelosin.bellproject.dao.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.util.Transfer;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

/**
 * Entity-объект стран
 */
@Data
@Entity
@Table(name = "Country")
public class Country {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(groups = {Transfer.Update.class})
    private int id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version = 0;

    /**
     * Код
     */
    @Column(name = "code")
    @NotNull(groups = {Transfer.Update.class, Transfer.Save.class})
    @JsonView({Transfer.DetailView.class})
    private int code;

    /**
     * Название
     */
    @Column(name = "Name", length = 20, nullable = false)
    @NotNull(groups = {Transfer.Update.class, Transfer.Save.class})
    @JsonView({Transfer.DetailView.class})
    private String name;
}