package com.zelosin.bellproject.util.mapper;

import com.zelosin.bellproject.dao.model.Employee;
import com.zelosin.bellproject.dao.model.Office;
import com.zelosin.bellproject.dao.model.Organization;
import com.zelosin.bellproject.view.transfer.EmployeeViewTransfer;
import com.zelosin.bellproject.view.transfer.OfficeViewTransfer;
import com.zelosin.bellproject.view.transfer.OrganizationViewTransfer;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

/**
 * Класс строитель-OrikaMapper'a
 */
@Service
public class OrikaMapperBuilder implements FactoryBean<MapperFactory> {
    /**
     * Создание бина маппера
     * @return бин маппера
     * @throws Exception ошибка маппинга
     */
    @Override
    public MapperFactory getObject() throws Exception {
        MapperFactory mapperFactory =
                new DefaultMapperFactory.
                    Builder()
                    .constructorResolverStrategy(null)
                    .build();

        mapperFactory.classMap(OrganizationViewTransfer.class, Organization.class)
                .field("baseCountryCode", "baseCountry.code")
                .byDefault()
                .register();

        mapperFactory.classMap(OfficeViewTransfer.class, Office.class)
                .field("baseCountryCode", "baseCountry.code")
                .field("orgId", "organization.id")
                .byDefault()
                .register();

        mapperFactory.classMap(EmployeeViewTransfer.class, Employee.class)
                .field("documentCode", "document.documentInfo.code")
                .field("officeId", "office.id")
                .field("date", "document.date")
                .field("citizenshipCode", "citizenship.citizenedCountry.code")
                .byDefault()
                .register();

        return mapperFactory;
    }

    /**
     * Полуение типа объекта
     * @return тип объекта
     */
    @Override
    public Class<?> getObjectType() {
        return MapperFactory.class;
    }

    /**
     * Является ли бин синглетоном
     * @return логическое значение
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}