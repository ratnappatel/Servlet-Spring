create table people (
id serial not null primary key,
first_name varchar(20) not null,
last_name varchar(20) not null,
age int not null
);

insert into people (id, first_name, last_name, age) values
(1, 'ratna', 'patel', 21),
(2,'uttam', ' patel', 30),
(3,'Ronit', ' Khandelwal', 32);

commit;