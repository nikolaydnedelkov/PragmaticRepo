CREATE SCHEMA `spotify` ;

CREATE TABLE users (
    id int,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    birth_date date,
    has_paid_app boolean,
    PRIMARY KEY (id)
);