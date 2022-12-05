package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.domain.Tutor;
import com.example.demo.dto.AddCourseRequest;
import com.example.demo.dto.AddStudentRequest;
import com.example.demo.dto.AddTutorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {
    private final CourseRepository courseRepository;
    private final StudentRepository studentRepository;
    private final TutorRepository tutorRepository;

    public AppService(CourseRepository courseRepository, StudentRepository studentRepository, TutorRepository tutorRepository) {
        this.courseRepository = courseRepository;
        this.studentRepository = studentRepository;
        this.tutorRepository = tutorRepository;
    }

    public Tutor addTutor(AddTutorRequest addTutorRequest) {
        Tutor tutor = new Tutor();
        tutor.setTutorName(addTutorRequest.getTutorName());
        tutor.setTutorSurname(addTutorRequest.getTutorSurname());
        return tutorRepository.save(tutor);
    }


    public Course addCourse(AddCourseRequest addCourseRequest) {
        Optional<Tutor> maybeTutor = tutorRepository.findById(addCourseRequest.getTutorId());
        Tutor tutor = maybeTutor.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tutor not found"));
        List<Student> studentsAttending = new ArrayList<>();
        Course course = new Course();
        course.setCourseName(addCourseRequest.getName());
        course.setTutor(tutor);
        course.setStudentsAttending(studentsAttending);
        return courseRepository.save(course);
    }


    public Student addStudent(AddStudentRequest addStudentRequest) {
        List<Course> CoursesAttending = new ArrayList<>();
        Student student = new Student();
        student.setStudentName(addStudentRequest.getStudentName());
        student.setStudentSurname(addStudentRequest.getStudentSurname());
        student.setCoursesAttending(CoursesAttending);
        return studentRepository.save(student);
    }


    public List<Course> searchStudentsCourses(Long id) {
        Optional<Student> maybeStudent = studentRepository.findById(id);
        Student student = maybeStudent.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
        return student.getCoursesAttending();
    }
}
