package com.example.demo.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long tutorId;
    @Column
    String tutorName;
    @Column
    String tutorSurname;


    public Tutor(Long tutorId, String tutorName, String tutorSurname) {
        this.tutorId = tutorId;
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
    }

    public Tutor() {

    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public String getTutorSurname() {
        return tutorSurname;
    }

    public void setTutorSurname(String tutorSurname) {
        this.tutorSurname = tutorSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tutor tutor)) return false;
        return tutorId.equals(tutor.tutorId) && tutorName.equals(tutor.tutorName) && tutorSurname.equals(tutor.tutorSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutorId, tutorName, tutorSurname);
    }
}
