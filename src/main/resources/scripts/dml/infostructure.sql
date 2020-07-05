insert into Organization(name, full_name, phone, inn, kpp, address, base_country_id)
    values('Yandex', 'Yandex Inc.', '880055535',
    1234567899, 987654321, 'Ул. Пушкина', 1);
insert into Organization(name, full_name, inn, kpp, address, base_country_id)
    values('Google', 'Google Inc.',
    2123456789, 298765432, 'St. Pushkina', 3);


insert into office(name, phone, office_country_id, organization_id)
    values('Yandex SP', null, 1, 1);
insert into office(name, phone, office_country_id, organization_id)
    values('Yandex EKB', '+1111111', 1, 1);
insert into office(name, phone, office_country_id, organization_id)
    values('Yandex FR', null, 4, 1);
insert into office(name, phone, office_country_id, organization_id)
    values('Yandex US', '+22222222', 2, 1);
insert into office(name, phone, office_country_id, organization_id)
    values('Google RU', '+33333333', 1, 2);
insert into office(name, phone, office_country_id, organization_id)
    values('Google US', '+4444444', 2, 2);
insert into office(name, phone, office_country_id, organization_id)
    values('Google GR', '+5555555', 3, 2);


insert into employee_position_info(name)
    values('Java junior developer');
insert into employee_position_info(name)
    values('Java middle developer');
insert into employee_position_info(name)
    values('Java senior developer');
insert into employee_position_info(name)
    values('C# junior developer');
insert into employee_position_info(name)
    values('HR');
insert into employee_position_info(name)
    values('CEO');


insert into employee_position(office_id, position_info_id)
    values(1, 1);
insert into employee_position(office_id, position_info_id)
    values(1, 2);
insert into employee_position(office_id, position_info_id)
    values(2, 3);
insert into employee_position(office_id, position_info_id)
    values(2, 4);
insert into employee_position(office_id, position_info_id)
    values(3, 1);
insert into employee_position(office_id, position_info_id)
    values(3, 2);
insert into employee_position(office_id, position_info_id)
    values(4, 3);
insert into employee_position(office_id, position_info_id)
    values(4, 4);
insert into employee_position(office_id, position_info_id)
    values(5, 6);
insert into employee_position(office_id, position_info_id)
    values(5, 6);
insert into employee_position(office_id, position_info_id)
    values(6, 6);
insert into employee_position(office_id, position_info_id)
    values(6, 3);
insert into employee_position(office_id, position_info_id)
    values(7, 6);
insert into employee_position(office_id, position_info_id)
    values(7, 1);


insert into employee(first_name, second_name, middle_name, phone, position_id, office_id)
    values('Иван', 'Иванов', 'Иванович', null, 1, 1);
insert into employee(first_name, second_name, middle_name, phone, position_id, office_id)
    values('Иван2', 'Иванов2', 'Иванович2', '+7777777', 2, 1);


insert into document(document_type, assign_date, employee_id)
    values(10, '2015-12-17', 1);
insert into document(document_type, assign_date, employee_id)
    values(12, '2019-12-19', 2);


insert into citizenship(name, citizenship_country_id, employee_id)
    values('Гражданство США', 3, 1);
insert into citizenship(name, citizenship_country_id, employee_id)
    values('Гражданство РФ', 1, 2);
