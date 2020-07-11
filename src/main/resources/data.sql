insert into Country(name, code) values
('Российская Федерация', 643);

insert into Country(name, code) values
('Германия', 276);

insert into Country(name, code) values
('США', 840);

insert into Country(name, code) values
('Франция', 250);



insert into Document_Type(name, code)
values ('Свидетельство о рождении', 3);

insert into Document_Type(name, code)
values ('Военный билет', 7);

insert into Document_Type(name, code)
values ('Временное удостоверение, выданное взамен военного билета ', 8);

insert into Document_Type(name, code)
values ('Паспорт иностранного гражданина', 10);

insert into Document_Type(name, code)
values ('Свидетельство о рассмотрении ходатайства о признании лица беженцем на территории Российской Федерации по существу', 11);

insert into Document_Type(name, code)
values ('Вид на жительство в Российской Федерации', 12);

insert into Document_Type(name, code)
values ('Удостоверение беженца', 13);

insert into Document_Type(name, code)
values ('Разрешение на временное проживание в Российской Федерации', 15);

insert into Document_Type(name, code)
values ('Свидетельство о предоставлении временного убежища на территории Российской Федерации', 18);

insert into Document_Type(name, code)
values ('Паспорт гражданина Российской Федерации', 21);

insert into Document_Type(name, code)
values ('Свидетельство о рождении, выданное уполномоченным органом иностранного государства', 23);

insert into Document_Type(name, code)
values ('Удостоверение личности военнослужащего Российской Федерации', 24);

insert into Document_Type(name, code)
values ('Иные документы', 91);



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


insert into employee(first_name, second_name, middle_name, phone, position, office_id)
values('Иван', 'Иванов', 'Иванович', null, 'Junior developer', 1);
insert into employee(first_name, second_name, middle_name, phone, position, office_id)
values('Иван2', 'Иванов2', 'Иванович2', '+7777777', 'CEO', 1);


insert into document(document_type, assign_date, employee_id)
values(10, '2015-12-17', 1);
insert into document(document_type, assign_date, employee_id)
values(12, '2019-12-19', 2);


insert into citizenship(name, citizenship_country_id, employee_id)
values('Гражданство США', 3, 1);
insert into citizenship(name, citizenship_country_id, employee_id)
values('Гражданство РФ', 1, 2);
