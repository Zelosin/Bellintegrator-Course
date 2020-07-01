CREATE TABLE IF NOT EXISTS Country (
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    code                    INT NOT NULL            COMMENT 'Код',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id)
) COMMENT 'Страны';

CREATE TABLE IF NOT EXISTS Organization(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    full_Name               VARCHAR(45) NOT NULL    COMMENT 'Полное название',
    inn                     INT(15) NOT NULL        COMMENT 'ИНН',
    kpp                     INT(15) NOT NULL        COMMENT 'КПП',
    address                 VARCHAR(45)             COMMENT 'Адрес',
    base_Country_Id         INT NOT NULL            COMMENT 'Страна, в которой расположена организация',
    is_Active               BOOL                    COMMENT 'Наличие активности',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (base_country_id)                   REFERENCES Country(id)
)COMMENT 'Организации';

CREATE TABLE IF NOT EXISTS Office(
    id                      INT NOT NULL            COMMENT 'Индентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    is_active               BOOL                    COMMENT 'Признак активности',
    office_country_id       INT NOT NULL            COMMENT 'Страна, где расположен офис',
    organization_id         INT NOT NULL            COMMENT 'Организация-владелец офиса',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (office_country_id)                 REFERENCES Country(id),
    FOREIGN KEY (organization_id)                   REFERENCES Organization(id)
)COMMENT 'Офисы';

CREATE TABLE IF NOT EXISTS Employee_Position(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id)
)COMMENT 'Должности работы';

CREATE TABLE IF NOT EXISTS Document_Type(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT ,
    name                    VARCHAR(45) NOT NULL    COMMENT 'Название',
    code                    INT NOT NULL            COMMENT 'Код',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id)
)COMMENT 'Типы документов и их описание';

CREATE TABLE IF NOT EXISTS Document(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    document_type_Id        INT NOT NULL            COMMENT 'Описание документа',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (document_type_id)                  REFERENCES Document_Type(id)
)COMMENT 'Документы';

CREATE TABLE IF NOT EXISTS Employee(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    first_name              VARCHAR(20) NOT NULL    COMMENT 'Имя',
    second_name             VARCHAR(20) NOT NULL    COMMENT 'Фамилия',
    middle_name             VARCHAR(20) NOT NULL    COMMENT 'Отчество',
    phone                   VARCHAR(20)             COMMENT 'Телефон',
    position_id             INT NOT NULL            COMMENT 'Должность',
    office_id               INT NOT NULL            COMMENT 'Офис сотрудника',
    document_id             INT NOT NULL            COMMENT 'Привязанный документ',
    is_identified           BOOL                    COMMENT 'Признак идентифицированности',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (position_id)                       REFERENCES Employee_Position(id),
    FOREIGN KEY (office_id)                         REFERENCES Office(id),
    FOREIGN KEY (document_id)                       REFERENCES Document(id)
)COMMENT 'Сотрудники';

CREATE TABLE IF NOT EXISTS Citizenship(
    id                      INT NOT NULL            COMMENT 'Идентификатор' AUTO_INCREMENT,
    name                    VARCHAR(20) NOT NULL    COMMENT 'Название',
    citizenship_country_id  INT NOT NULL            COMMENT 'Страна гражданства',
    employee_id             INT NOT NULL            COMMENT 'Сотрудник-владелец гражданства',
    version                 INT NOT NULL            COMMENT 'Служебное поле hibernate',
    PRIMARY KEY (id),
    FOREIGN KEY (citizenship_country_id)            REFERENCES Country(id),
    FOREIGN KEY (employee_id)                       REFERENCES Employee(id)
)COMMENT 'Гражданства';
