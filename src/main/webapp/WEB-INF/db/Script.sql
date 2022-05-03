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
) character set='latin1' charset='utf8' collate='latin1_spanish_ci';

INSERT INTO teacher VALUES ("COD00001", "Pepe", "Lucho", "pepe@gmail.com", 23, 32.4, "999999999", 1, "2000-01-01");

SELECT * FROM teacher;

SET SQL_SAFE_UPDATES = 0;

DELETE FROM teacher;

ALTER TABLE teacher ADD COLUMN courseId CHAR(5) AFTER id;

ALTER TABLE teacher character set='latin1' collate='latin1_spanish_ci';

DROP TABLE IF EXISTS course;

CREATE TABLE course (
	`id`			CHAR(5),
    `name`			VARCHAR(80),
    `description`	TEXT,
    PRIMARY KEY (`id`)
) character set='latin1' collate='latin1_spanish_ci';

INSERT INTO course VALUES ('C001', 'Python', 'This course is made to learn Python'),
('C002', 'Java', 'This course is made to learn Java'),
('C003', 'C#', 'This course is made to learn C#');

SELECT * FROM course;