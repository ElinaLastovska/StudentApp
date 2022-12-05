package com.example.demo;

import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.domain.Tutor;
import com.example.demo.dto.AddCourseRequest;
import com.example.demo.dto.AddStudentRequest;
import com.example.demo.dto.AddTutorRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AppController {

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }


    @PutMapping("/add-student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student addStudent(@RequestBody AddStudentRequest addStudentRequest) {
        return this.appService.addStudent(addStudentRequest);
    }

    @PutMapping("/add-tutor")
    @ResponseStatus(HttpStatus.CREATED)
    public Tutor addTutor(@RequestBody AddTutorRequest addTutorRequest) {
        return this.appService.addTutor(addTutorRequest);
    }

    @PutMapping("/add-course")
    @ResponseStatus(HttpStatus.CREATED)
    public Course addCourse(@RequestBody AddCourseRequest addCourseRequest) {
        return this.appService.addCourse(addCourseRequest);
    }

    @GetMapping("/get-student-courses/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<Course> searchStudentsCourses(@PathVariable Long id) {
        return appService.searchStudentsCourses(id);
    }

    @PutMapping("/add-course-to-student")
    @ResponseStatus(HttpStatus.OK)
    public Student addCourseToStudent(@RequestBody Long courseId, Long studentId){
        return appService.addCourseToStudent(courseId, studentId);
    }

}
