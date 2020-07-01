CREATE TABLE Country (
                         Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                         Name VARCHAR(20) NOT NULL,
                         PRIMARY KEY (Id)
);


CREATE TABLE Organization(
                             Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                             Name VARCHAR2(20) NOT NULL,
                             Full_Name VARCHAR2(45) NOT NULL,
                             INN NUMBER(15, 0) NOT NULL,
                             KPP NUMBER(15, 0) NOT NULL,
                             Address VARCHAR2(45),
                             Phone VARCHAR2(20),
                             Base_Country_Id INT NOT NULL,
                             Is_Active CHAR(1),
                             CONSTRAINT Organization CHECK (Is_Active IN ('1','0')),
                             PRIMARY KEY (Id),
                             FOREIGN KEY (Base_Country_Id) REFERENCES Country(Id)
);

create table Office(
                       Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                       Name VARCHAR2(20) NOT NULL,
                       Phone VARCHAR2(20),
                       Is_Active CHAR(1),
                       Office_Country_Id INT NOT NULL,
                       Organization_Id INT NOT NULL,
                       CONSTRAINT Office CHECK (Is_Active IN ('1','0')),
                       PRIMARY KEY (Id),
                       FOREIGN KEY (Office_Country_Id) REFERENCES Country(Id),
                       FOREIGN KEY (Organization_Id) REFERENCES Organization(Id)
);

create table Position(
                         Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                         Name VARCHAR2(20) NOT NULL,
                         PRIMARY KEY (Id)
);

create table Citizenship(
                            Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                            Citizenship_Country_Id INT NOT NULL,
                            Name VARCHAR2(20) NOT NULL,
                            PRIMARY KEY (Id),
                            FOREIGN KEY (Citizenship_Country_Id) REFERENCES Country(Id)
);


create table Document_Info(
                              Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                              Name VARCHAR2(45) NOT NULL,
                              Code NUMBER NOT NULL,
                              PRIMARY KEY (Id)
);

create table Document(
                         Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                         Document_Info_Id NUMBER NOT NULL,
                         PRIMARY KEY (Id),
                         FOREIGN KEY (Document_Info_Id) references Document_Info(Id)
);

create table Employee(
                         Id NUMBER GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1) NOT NULL,
                         First_Name VARCHAR2(20) NOT NULL,
                         Second_Name VARCHAR2(20) NOT NULL,
                         Middle_Name VARCHAR2(20) NOT NULL,
                         Phone VARCHAR2(20),
                         Position_Id NUMBER NOT NULL,
                         Citizenship_Id NUMBER NOT NULL,
                         Office_Id NUMBER NOT NULL,
                         Document_Id NUMBER NOT NULL,
                         Is_Idenified CHAR(1),
                         PRIMARY KEY (Id),
                         CONSTRAINT Employee CHECK (Is_Idenified IN ('1','0')),
                         FOREIGN KEY (Position_Id) references Position(Id),
                         FOREIGN KEY (Citizenship_Id) references Citizenship(Id),
                         FOREIGN KEY (Office_Id) references Office(Id),
                         FOREIGN KEY (Document_Id) references Document(Id)
);
