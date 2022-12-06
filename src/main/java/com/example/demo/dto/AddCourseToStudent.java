package com.example.demo.dto;

import java.util.Objects;

public class AddCourseToStudent {
    private Long courseId;
    private Long studentId;

    public AddCourseToStudent(Long courseId, Long studentId) {
        this.courseId = courseId;
        this.studentId = studentId;
    }
    public AddCourseToStudent() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCourseToStudent that)) return false;
        return courseId.equals(that.courseId) && studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, studentId);
    }
}
