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

CREATE TABLE users
(
    id       BIGINT       NOT NULL AUTO_INCREMENT,
    email    VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE `authordb`.`users`
    ADD UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE;

ALTER TABLE `authordb`.`users`
    ADD COLUMN `first_name` VARCHAR(255) NULL DEFAULT NULL AFTER `password`,
    ADD COLUMN `last_name` VARCHAR(255) NULL DEFAULT NULL AFTER `first_name`,
    ADD COLUMN `created_at` TIMESTAMP NULL DEFAULT NULL AFTER `last_name`,
    ADD COLUMN `updated_at` TIMESTAMP NULL DEFAULT NULL AFTER `created_at`,
    ADD COLUMN `role` VARCHAR(255) NOT NULL AFTER 'role';


UPDATE `authordb`.`users`
SET `email` = 'Ilya@mail.ru'
WHERE (`id` = '1');
UPDATE `authordb`.`users`
SET `email` = 'Anton@mail.ru'
WHERE (`id` = '2');
UPDATE `authordb`.`users`
SET `password` = '987654'
WHERE (`id` = '1');
UPDATE `authordb`.`users`
SET `password` = '123456'
WHERE (`id` = '2');


CREATE TABLE roles
(
    id   BIGINT       NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE INDEX name_UNIQUE (name ASC) VISIBLE
);

INSERT INTO roles (name)
VALUES ('ADMIN');
INSERT INTO roles (name)
VALUES ('MANAGER');
INSERT INTO roles (name)
VALUES ('USER');

CREATE TABLE users_roles
(
    users_id BIGINT NOT NULL,
    roles_id BIGINT NOT NULL
);

ALTER TABLE users_roles
    ADD INDEX fk_users_idx (users_id ASC) VISIBLE,
    ADD INDEX fk_roles_idx (roles_id ASC) VISIBLE;
;
ALTER TABLE users_roles
    ADD CONSTRAINT fk_users
        FOREIGN KEY (users_id)
            REFERENCES users (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    ADD CONSTRAINT fk_roles
        FOREIGN KEY (roles_id)
            REFERENCES roles (id)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION;

INSERT INTO users_roles (users_id, roles_id)
VALUES ('1', '1');