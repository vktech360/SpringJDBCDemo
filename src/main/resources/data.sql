create table employee
(
id integer not null,
firstname varchar(255) not null,
lastname varchar(255) not null,
department varchar(255) not null,
location varchar(255) not null,
primary key(id)
);

insert into employee(id,firstname,lastname,department,location) values(1,'Rohit','Sharma','Sales','Mumbai');
insert into employee(id,firstname,lastname,department,location) values(2,'Arjun','Singh','Account','Noida');