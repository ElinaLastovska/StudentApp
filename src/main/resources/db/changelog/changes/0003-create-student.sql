--liquibase formatted sql
--changeset Elina:3

CREATE TABLE student
(
    student_id      INTEGER     NOT NULL AUTO_INCREMENT,
    student_name    VARCHAR(50) NOT NULL,
    student_surname VARCHAR(50) NOT NULL,
    PRIMARY KEY (student_id)

);
