DROP DATABASE IF EXISTS institution;

CREATE DATABASE institution;

USE institution;

DROP TABLE IF EXISTS teacher;

CREATE TABLE teacher (
	id			CHAR(8),
    firstName	VARCHAR(80),
    lastName	VARCHAR(80),
    email		VARCHAR(80),
    age			smallint,
    money		double,
    phone		CHAR(9),
    gender		smallint,
    birthday	date,
    PRIMARY KEY (id)
);

INSERT INTO teacher VALUES ("COD00001", "Pepe", "Lucho", "pepe@gmail.com", 23, 32.4, "999999999", 1, "2000-01-01");

SELECT * FROM teacher;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM teacher;