create database authordb;

use authordb;

create table authors
(
id int primary key,
firstName varchar(100),
lastName varchar(100)
);

insert into authors (id, firstname, lastname)
values
(1, 'Михаил', 'Лермонтов'),
(2, 'Лев', 'Толстой'),
(3, 'Александр', 'Пушкин'),
(4, 'Сергей', 'Есенин'),
(5, 'Николай', 'Гумилев');

create table book(
id int primary key,
title varchar(100),
price int,
imageUrl varchar(100),
createdAt DATE,
updatedAt DATE,
authorId INT,
FOREIGN KEY (authorId) references authors(id)
);

insert into book (id, title, price, imageUrl, createdAt, updatedAt, authorId)
values
(1, 'Мцыри', 100, 'www', '1995-02-01', '2011-02-05', 1),
(2, 'Война и мир', 200, 'ccc', '1996-02-01', '2021-02-05', 2),
(3, 'Руслан и Людмила', 150, 'qqq', '1997-02-01', '2012-02-05', 3),
(4, 'Демон', 200, 'zzz', '1998-02-01', '2013-02-05', 1),
(5, 'Бородино', 300, 'sss', '1994-02-01', '2014-02-05', 1),
(6, 'Стихи', 500, 'aaa', '2000-02-01', '2003-11-25', 4),
(7, 'Африка', 300, 'bbb', '2001-03-06', '2011-11-26', 5);