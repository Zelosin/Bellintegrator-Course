CREATE TABLE IF NOT EXISTS Country (
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    code                    INT NOT NULL            COMMENT 'Код',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id)
) COMMENT 'Страны';

CREATE TABLE IF NOT EXISTS Organization(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    full_name               VARCHAR(45) NOT NULL    COMMENT 'Полное название',
    inn                     INT(15) NOT NULL        COMMENT 'ИНН',
    kpp                     INT(15) NOT NULL        COMMENT 'КПП',
    address                 VARCHAR(45)             COMMENT 'Адрес',
    base_Country_Id         INT NOT NULL            COMMENT 'Страна, в которой расположена организация',
    is_active               BOOL DEFAULT TRUE       COMMENT 'Наличие активности',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (base_country_id)                   REFERENCES Country(id)
)COMMENT 'Организации';

CREATE TABLE IF NOT EXISTS Office(
    id                      INT NOT NULL            COMMENT 'Индентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    is_active               BOOL DEFAULT TRUE       COMMENT 'Признак активности',
    office_country_id       INT NOT NULL            COMMENT 'Страна, где расположен офис',
    organization_id         INT NOT NULL            COMMENT 'Организация-владелец офиса',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (office_country_id)                 REFERENCES Country(id),
    FOREIGN KEY (organization_id)                   REFERENCES Organization(id)
)COMMENT 'Офисы';

CREATE TABLE IF NOT EXISTS Document_Type(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT ,
    name                    VARCHAR(150) NOT NULL   COMMENT 'Название',
    code                    INT NOT NULL            COMMENT 'Код',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id)
)COMMENT 'Типы документов и их описание';

CREATE TABLE IF NOT EXISTS Citizenship(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20)             COMMENT 'Название',
    citizenship_country_id  INT NOT NULL            COMMENT 'Страна гражданства',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (citizenship_country_id)            REFERENCES Country(id)
)COMMENT 'Гражданства';

CREATE TABLE IF NOT EXISTS Employee(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    first_name              VARCHAR(20) NOT NULL    COMMENT 'Имя',
    second_name             VARCHAR(20)             COMMENT 'Фамилия',
    middle_name             VARCHAR(20)             COMMENT 'Отчество',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    position                VARCHAR(20) NOT NULL    COMMENT 'Должность',
    office_id               INT NOT NULL            COMMENT 'Офис сотрудника',
    citizenship_id          INT                     COMMENT 'Гражданство сотрудника',
    is_identified           BOOL DEFAULT FALSE      COMMENT 'Признак идентифицированности',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (office_id)                         REFERENCES Office(id),
    FOREIGN KEY (citizenship_id)                    REFERENCES Citizenship(id)
)COMMENT 'Сотрудники';

CREATE UNIQUE INDEX UX_Document_Type_Code           ON Document_Type(code);

CREATE TABLE IF NOT EXISTS Document(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    document_type           INT NOT NULL            COMMENT 'Описание документа',
    assign_date             DATE                    COMMENT 'Дата удостоверения',
    employee_id             INT NOT NULL            COMMENT 'Сотрудник-владелец документа',
    version                 INT NOT NULL DEFAULT 0  COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (document_type)                     REFERENCES Document_Type(id),
    FOREIGN KEY (employee_id)                       REFERENCES Employee(id)
)COMMENT 'Документы';

CREATE UNIQUE INDEX UX_Country_Code                 ON Country(code);
CREATE UNIQUE INDEX UX_Document_Employee_Id         ON Document(employee_id);
CREATE UNIQUE INDEX UX_Organization_Name_Full_Name  ON Organization(name, full_name);
CREATE UNIQUE INDEX UX_Organization_inn_kpp         ON Organization(inn, kpp);

CREATE INDEX        IX_Organization_Name            ON Organization(name);
CREATE INDEX        IX_Organization_INN             ON Organization(inn);
CREATE INDEX        IX_Organization_Is_Active       ON Organization(is_active);

CREATE INDEX        IX_Office_Organization_Id       ON Office(organization_id);
CREATE INDEX        IX_Office_Name                  ON Office(name);
CREATE INDEX        IX_Office_Phone                 ON Office(phone);
CREATE INDEX        IX_Office_Is_Active             ON Office(is_active);

CREATE INDEX        IX_Employee_Office_Id           ON Employee(office_id);
CREATE INDEX        IX_Employee_First_Name          ON Employee(first_name);
CREATE INDEX        IX_Employee_Second_Name         ON Employee(second_name);
CREATE INDEX        IX_Employee_Middle_Name         ON Employee(middle_name);
CREATE INDEX        IX_Employee_Position            ON Employee(position);

CREATE INDEX        IX_Document_Employee_Id         ON Document(employee_id);

CREATE INDEX        IX_Document_Type_Code           ON Document_Type(code);
