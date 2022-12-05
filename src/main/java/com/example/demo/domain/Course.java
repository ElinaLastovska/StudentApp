package com.example.demo.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long courseId;

    String courseName;
    @ManyToMany(mappedBy = "CoursesAttending")
    List<Student> studentsAttending;
    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    public Course() {
    }

    public Course(Long courseId, String courseName, Tutor tutor, List<Student> studentsAttending) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.tutor = tutor;
        this.studentsAttending = studentsAttending;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public List<Student> getStudentsAttending() {
        return studentsAttending;
    }

    public void setStudentsAttending(List<Student> studentsAttending) {
        this.studentsAttending = studentsAttending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;
        return courseId.equals(course.courseId) && courseName.equals(course.courseName) && tutor.equals(course.tutor) && studentsAttending.equals(course.studentsAttending);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, tutor, studentsAttending);
    }
}
