package com.zelosin.bellproject.dao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Entity-объект организации
 */
@Data
@Entity
@Table(name = "Organization")
@AllArgsConstructor
@NoArgsConstructor
public class Organization {

    /**
     * Идентификатор
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version = 0;

    /**
     * Название
     */
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    /**
     * Полное название
     */
    @Column(name = "full_name", nullable = false, length = 45)
    private String fullName;

    /**
     * ИНН
     */
    @Column(name = "inn", length = 15)
    private Long INN;

    /**
     * КПП
     */
    @Column(name = "kpp", length = 15)
    private Long KPP;

    /**
     * Адрес
     */
    @Column(name = "address", length = 45)
    private String address;

    /**
     * Телефон
     */
    @Column(name = "phone", length = 20)
    private String phone;

    /**
     * Признак активности
     */
    @Column(name = "is_active")
    private Boolean isActive = true;

    /**
     * Страна организации
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "base_country_id")
    private Country baseCountry;
}