--liquibase formatted sql
--changeset Elina:4

CREATE TABLE student_course
(

    student_id INTEGER NOT NULL,
    course_id  INTEGER NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);