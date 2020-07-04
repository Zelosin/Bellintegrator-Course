package com.zelosin.bellproject.dao.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.zelosin.bellproject.dao.transfer.Transfer;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Organization")
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
    @ManyToOne
    @JoinColumn(name = "base_country_id")
    private Country baseCountry;

    /**
     * Список офисов
     */
    @OneToMany(
            mappedBy = "organization",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Office> officeList = new ArrayList<>();

    /**
     * Добавление нового офиса
     * @param office - типовой офис
     */
    public synchronized void addOffice(Office office){
        office.setOrganization(this);
        officeList.add(office);
    }

}
