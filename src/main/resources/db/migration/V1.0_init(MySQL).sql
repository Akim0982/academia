create table author
(
    id         BIGINT NOT NULL AUTO_INCREMENT,
    first_name varchar(255) DEFAULT NULL,
    last_name  varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
);


create table book
(
    id         BIGINT    NOT NULL AUTO_INCREMENT,
    created_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    image_url  varchar(255)       DEFAULT NULL,
    price      decimal(19, 2)     DEFAULT NULL,
    title      varchar(255)       DEFAULT NULL,
    updated_at timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
    author_id  BIGINT    NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_author_id FOREIGN KEY (author_id) REFERENCES author (id)
);

DELETE FROM book.book WHERE (id = '7');

INSERT INTO book.book
    (id, title, price, image_url, created_at, updated_at, author_id)
     VALUES ('7', 'Африка', '200', 'qqq', '2001-03-05', '2021-10-20', '1');