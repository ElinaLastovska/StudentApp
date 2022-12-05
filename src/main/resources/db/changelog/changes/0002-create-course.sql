--liquibase formatted sql
--changeset Elina:2
CREATE TABLE course
(
    course_id   INTEGER     NOT NULL AUTO_INCREMENT,
    course_name VARCHAR(50) NOT NULL,
    tutor_id    INTEGER     NOT NULL,
    PRIMARY KEY (course_id),
    FOREIGN KEY (tutor_id) REFERENCES tutor (tutor_id)
);