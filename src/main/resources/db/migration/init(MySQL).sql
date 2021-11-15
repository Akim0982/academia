create database library_db;

use library_db;

create TABLE author (
            id BIGINT NOT NULL AUTO_INCREMENT,
            first_name varchar(255) DEFAULT NULL,
            last_name varchar(255) DEFAULT NULL,
            PRIMARY KEY (id)
            );

insert into author (id, first_name, last_name)
values
(1, 'Михаил', 'Лермонтов'),
(2, 'Лев', 'Толстой'),
(3, 'Александр', 'Пушкин'),
(4, 'Сергей', 'Есенин'),
(5, 'Николай', 'Гумилев');


create TABLE book (
            id BIGINT NOT NULL AUTO_INCREMENT,
            created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
            image_url varchar(255) DEFAULT NULL,
            price decimal(19,2) DEFAULT NULL,
            title varchar(255) DEFAULT NULL,
            updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
            author_id BIGINT NOT NULL,
            PRIMARY KEY (id),
            CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES author (id)
            );

insert into book (id, title, price, image_url, created_at, updated_at, author_id)
values
(1, 'Мцыри', 100, 'www', '1995-02-01', '2011-02-05', 1),
(2, 'Война и мир', 200, 'ccc', '1996-02-01', '2021-02-05', 2),
(3, 'Руслан и Людмила', 150, 'qqq', '1997-02-01', '2012-02-05', 3),
(4, 'Демон', 200, 'zzz', '1998-02-01', '2013-02-05', 1),
(5, 'Бородино', 300, 'sss', '1994-02-01', '2014-02-05', 1),
(6, 'Стихи', 500, 'aaa', '2000-02-01', '2003-11-25', 4),
(7, 'Африка', 300, 'bbb', '2001-03-06', '2011-11-26', 5);