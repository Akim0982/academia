CREATE TABLE author
(
    id SERIAL PRIMARY KEY,
    firstName CHARACTER VARYING(100),
    lastName CHARACTER VARYING(100)
);

INSERT INTO author (id, firstname, lastname)
VALUES
(1, 'Михаил', 'Лермонтов'),
(2, 'Лев', 'Толстой'),
(3, 'Александр', 'Пушкин'),
(4, 'Сергей', 'Есенин'),
(5, 'Николай', 'Гумилев');


CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  title CHARACTER VARYING(100),
  price INTEGER,
  imageUrl VARCHAR(100),
  createdAt date,
  updatedAt date,
  author_id INTEGER,
  FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO book (id, title, price, imageurl, createdat, updatedat, author_id)
VALUES
(1, 'Мцыри', 100, 'www', '1995-02-01', '2011-02-05', 1),
(2, 'Война и мир', 200, 'ccc', '1996-02-01', '2021-02-05', 2),
(3, 'Руслан и Людмила', 150, 'qqq', '1997-02-01', '2012-02-05', 3),
(4, 'Демон', 200, 'zzz', '1998-02-01', '2013-02-05', 1),
(5, 'Бородино', 300, 'sss', '1994-02-01', '2014-02-05', 1),
(6, 'Стихи', 500, 'aaa', '2000-02-01', '2003-11-25', 4),
(7, 'Африка', 300, 'bbb', '2001-03-06', '2011-11-26', 5);
