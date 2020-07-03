package com.zelosin.bellproject.dao.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.transfer.Transfer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
