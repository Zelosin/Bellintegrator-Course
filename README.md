# Bellintegrator-Course
Проект, выполняемый во время прохождения курса от Bellintergator

  <ul>
    <a href="#bd"><li>Конфигурация базы данных</li></a>
    <a href="#start"><li>Запуск программы</li></a>
    <a href="#model"><li>Модель данных</li></a>
    <a href="#comm"><li>Комментарии разработчика</li></a>
  </ul>

<h3><a id="bd"></a>Конфигурация базы данных</h3>

  Программа использует в качестве `СУБД MySql`, поэтому перед ее запуском следует установить `MySQL Worckbench` или воспользоваться стандартным терминалом. 
  Первым делом нужно создать пользователя, через которого будет осуществляться работа с базой. Для этого необходимо выполнить следующие команды:
  <ol>
    <p>
      <li>Создание нового пользователя производится выполнением команды 

```sql
CREATE USER 'bell' IDENTIFIED BY 'password';
```
  где 'bell' - логин, а 'password' - соответсвенно, пароль.
    </li>
    </p>
    <p>
    <li>Предоставление доступа новому пользователю к информации быза данных
      
```sql
GRANT ALL PRIVILEGES ON * . * TO 'bell';
```
    
  </li>
    </p>
    <p>
  
  <li>Обновление прав доступа
    
```sql
FLUSH PRIVILEGES;
```
  </li>
    </p>
  </ol>
  
  Далее будет необходимо создать соединение с базой данных данных и выполнить создание таблиц с их последующим заполнением первичными данными, пример в `MySQL Workbench`:
  
  <ol>
   <li>Создание нового подключения<br>
    <img src="https://user-images.githubusercontent.com/34071380/87415946-9c0d1e00-c5d6-11ea-9a62-1fb89710d0b8.png">
   </li>
   <li>Конфигурация нового подключения
     <img src="https://user-images.githubusercontent.com/34071380/87415697-24d78a00-c5d6-11ea-87cc-bcce1f1bee8a.png">
    </li>
   <li>Ввод логина и пароля<br>
     <img src="https://user-images.githubusercontent.com/34071380/87415531-daeea400-c5d5-11ea-98e8-bde4984ba7b5.png">
    </li>

  После необходимо выполнить два набора команд, которые находятся в файлах `schema.sql` и `data.sql` в папке `binaries`.

   <li>Выбор файла с командами конфигурации<br>
    <img src="https://user-images.githubusercontent.com/34071380/87416263-1f2e7400-c5d7-11ea-848b-0dd5bb830f66.png">
   </li>
   <li>Исполнение команд<br>
     <img src="https://user-images.githubusercontent.com/34071380/87416449-67e62d00-c5d7-11ea-8c05-417066c28cb3.png">
    </li>
  </ol> 
  
<h3><a id="start"></a>Запуск программы</h3>
  Программа запускается следующей иструкцией коммандной строки:<br>
  
```
java -jar bell-project.jar
```
<h5>Пример запуска:</h5><br>
  <img src="https://user-images.githubusercontent.com/34071380/87418410-505c7380-c5da-11ea-90bb-bf26e548c770.gif">
 <br>

После этого по адресу <a href="http://localhost:8080"> localhost:8080 </a> будут обрабатываться необходимые запросы. 

<h5>Пример запросов через PostmanCanary:</h5>
<img src="https://user-images.githubusercontent.com/34071380/87419423-22782e80-c5dc-11ea-841e-9e4a82b26c9f.png">

<img src="https://user-images.githubusercontent.com/34071380/87419278-e0e78380-c5db-11ea-82db-58b8c8bcd686.png">


<h3><a id="model"></a>Модель данных</h3>


<img src="https://user-images.githubusercontent.com/34071380/87060287-060e7780-c213-11ea-9daf-228f24d5f856.jpg">

<img src="https://user-images.githubusercontent.com/34071380/87060123-d0698e80-c212-11ea-8eaf-4c15c077a079.png">

<img src="https://user-images.githubusercontent.com/34071380/87411552-8b59a980-c5d0-11ea-8b22-23eac0be9d24.png">

<h3><a id="comm"></a>Комментарии разработчика</h3>



