package com.example.demo.domain;


import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long studentId;

    String studentName;

    String studentSurname;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    List<Course> CoursesAttending;

    public Student() {
    }

    public Student(Long studentId, String studentName, String studentSurname, List<Course> coursesAttending) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentSurname = studentSurname;
        CoursesAttending = coursesAttending;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
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

    public List<Course> getCoursesAttending() {
        return CoursesAttending;
    }

    public void setCoursesAttending(List<Course> coursesAttending) {
        CoursesAttending = coursesAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return studentId.equals(student.studentId) && studentName.equals(student.studentName) && studentSurname.equals(student.studentSurname) && CoursesAttending.equals(student.CoursesAttending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, studentSurname, CoursesAttending);
    }
}
