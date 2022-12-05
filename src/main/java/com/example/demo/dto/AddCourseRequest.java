package com.example.demo.dto;

import java.util.Objects;

public class AddCourseRequest {
    String name;
    Long tutorId;

    public AddCourseRequest(String name, Long tutorId) {
        this.name = name;
        this.tutorId = tutorId;
    }

    public AddCourseRequest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddCourseRequest addCourseRequest)) return false;
        return name.equals(addCourseRequest.name) && tutorId.equals(addCourseRequest.tutorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tutorId);
    }
}
