package com.example.demo.dto;

import java.util.Objects;

public class AddStudentRequest {

    private String studentName;
    private String studentSurname;


    public AddStudentRequest(String studentName, String studentSurname) {
        this.studentName = studentName;
        this.studentSurname = studentSurname;
    }

    public AddStudentRequest() {

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentSurname() {
        return studentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddStudentRequest that)) return false;
        return studentName.equals(that.studentName) && studentSurname.equals(that.studentSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, studentSurname);
    }
}
