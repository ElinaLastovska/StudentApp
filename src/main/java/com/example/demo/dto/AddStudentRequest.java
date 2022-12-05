package com.example.demo.dto;

import java.util.Objects;

public class AddStudentRequest {

    String StudentName;
    String StudentSurname;


    public AddStudentRequest(String studentName, String studentSurname) {
        StudentName = studentName;
        StudentSurname = studentSurname;

    }

    public AddStudentRequest() {

    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentSurname() {
        return StudentSurname;
    }

    public void setStudentSurname(String studentSurname) {
        StudentSurname = studentSurname;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddStudentRequest that)) return false;
        return StudentName.equals(that.StudentName) && StudentSurname.equals(that.StudentSurname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(StudentName, StudentSurname);
    }
}
