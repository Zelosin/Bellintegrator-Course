CREATE TABLE Country (
                         Id INT AUTO_INCREMENT NOT NULL,
                         Name VARCHAR(20) NOT NULL,
                         PRIMARY KEY (Id)
);


CREATE TABLE Organization(
                             Id INT AUTO_INCREMENT NOT NULL,
                             Name VARCHAR(20) NOT NULL,
                             Full_Name VARCHAR(45) NOT NULL,
                             INN INT(15) NOT NULL,
                             KPP INT(15) NOT NULL,
                             Address VARCHAR(45),
                             Phone VARCHAR(20),
                             Base_Country_Id INT NOT NULL,
                             Is_Active BOOL,
                             PRIMARY KEY (Id),
                             FOREIGN KEY (Base_Country_Id) REFERENCES Country(Id)
);

create table Office(
                       Id INT AUTO_INCREMENT NOT NULL,
                       Name VARCHAR(20) NOT NULL,
                       Phone VARCHAR(20),
                       Is_Active BOOL,
                       Office_Country_Id INT NOT NULL,
                       Organization_Id INT NOT NULL,
                       PRIMARY KEY (Id),
                       FOREIGN KEY (Office_Country_Id) REFERENCES Country(Id),
                       FOREIGN KEY (Organization_Id) REFERENCES Organization(Id)
);

create table `Position`(
                         Id INT AUTO_INCREMENT NOT NULL ,
                         Name VARCHAR(20) NOT NULL,
                         PRIMARY KEY (Id)
);

create table Citizenship(
                            Id INT AUTO_INCREMENT NOT NULL,
                            Citizenship_Country_Id INT NOT NULL,
                            Name VARCHAR(20) NOT NULL,
                            PRIMARY KEY (Id),
                            FOREIGN KEY (Citizenship_Country_Id) REFERENCES Country(Id)
);


create table Document_Info(
                              Id INT AUTO_INCREMENT NOT NULL,
                              Name VARCHAR(45) NOT NULL,
                              Code INT NOT NULL,
                              PRIMARY KEY (Id)
);

create table Document(
                         Id INT AUTO_INCREMENT NOT NULL,
                         Document_Info_Id INT NOT NULL,
                         PRIMARY KEY (Id),
                         FOREIGN KEY (Document_Info_Id) references Document_Info(Id)
);

create table `Employee`(
                         Id INT AUTO_INCREMENT NOT NULL,
                         First_Name VARCHAR(20) NOT NULL,
                         Second_Name VARCHAR(20) NOT NULL,
                         Middle_Name VARCHAR(20) NOT NULL,
                         Phone VARCHAR(20),
                         Position_Id INT NOT NULL,
                         Citizenship_Id INT NOT NULL,
                         Office_Id INT NOT NULL,
                         Document_Id INT NOT NULL,
                         Is_Idenified BOOL,
                         PRIMARY KEY (Id),
                         FOREIGN KEY (`Position_Id`) references `Position`(`Id`),
                         FOREIGN KEY (`Citizenship_Id`) references `Citizenship`(`Id`),
                         FOREIGN KEY (`Office_Id`) references `Office`(`Id`),
                         FOREIGN KEY (`Document_Id`) references `Document`(`Id`)
);
