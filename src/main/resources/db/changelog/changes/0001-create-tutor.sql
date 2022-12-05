--liquibase formatted sql
--changeset Elina:1
CREATE TABLE tutor
(
    tutor_id      INTEGER     NOT NULL AUTO_INCREMENT,
    tutor_name    VARCHAR(50) NOT NULL,
    tutor_surname VARCHAR(50) NOT NULL,
    PRIMARY KEY (tutor_id)
);


