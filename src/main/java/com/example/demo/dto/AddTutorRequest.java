package com.example.demo.dto;


import java.util.Objects;

public class AddTutorRequest {

    private String tutorName;
    private String tutorSurname;

    public AddTutorRequest(String tutorName, String tutorSurname) {
        this.tutorName = tutorName;
        this.tutorSurname = tutorSurname;
    }

    public AddTutorRequest() {
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
        if (!(o instanceof AddTutorRequest that)) return false;
        return tutorName.equals(that.tutorName) && tutorSurname.equals(that.tutorSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tutorName, tutorSurname);
    }
}
