--drop table if exists countperson cascade;

create table PERSON(
    id INT PRIMARY KEY AUTO_INCREMENT NOT NUll,
    name text not null,
    counter int not null,
    language text not null
);