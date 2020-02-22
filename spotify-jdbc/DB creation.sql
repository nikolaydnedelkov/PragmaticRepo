CREATE SCHEMA `spotify` ;

CREATE TABLE users (
    id int AUTO_INCREMENT,
    first_name varchar(255),
    last_name varchar(255),
    email varchar(255),
    birth_date date,
    has_paid_app boolean,
    PRIMARY KEY (id)
);

CREATE TABLE artists (
    id int AUTO_INCREMENT,
    first_name varchar(255),
    last_name varchar(255),
    birth_date date,
    genre varchar(255),
    PRIMARY KEY (id)
);

CREATE TABLE songs (
    id int AUTO_INCREMENT,
    name varchar(255),
    release_date date,
    song_length int,
    artist_id int,
    PRIMARY KEY (id) , 
    FOREIGN KEY (artist_id) REFERENCES artists(id)
);