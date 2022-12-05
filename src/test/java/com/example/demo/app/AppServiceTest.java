package com.example.demo.app;

import com.example.demo.AppService;
import com.example.demo.CourseRepository;
import com.example.demo.StudentRepository;
import com.example.demo.TutorRepository;
import com.example.demo.domain.Course;
import com.example.demo.domain.Student;
import com.example.demo.domain.Tutor;
import com.example.demo.dto.AddCourseRequest;
import com.example.demo.dto.AddStudentRequest;
import com.example.demo.dto.AddTutorRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class AppServiceTest {

    @Mock
    TutorRepository tutorRepository;
    @Mock
    CourseRepository courseRepository;
    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    AppService appService;


    @Test
    public void testAddTutor() {
        AddTutorRequest addTutorRequest = new AddTutorRequest("Andris", "Berzins");
        Mockito.doAnswer(invocation -> {
            Tutor testTutor = invocation.getArgument(0);
            Assertions.assertEquals(addTutorRequest.getTutorName(), testTutor.getTutorName());
            return null;
        }).when(tutorRepository).save(Mockito.any(Tutor.class));
        appService.addTutor(addTutorRequest);
    }


    @Test
    public void testAddCourse() {
        Tutor tutor = new Tutor(1L, "Juris", "Berzins");

        AddCourseRequest addCourseRequest = new AddCourseRequest("Math", 1L);

        Optional<Tutor> test = Optional.of(tutor);
        when(tutorRepository.findById(addCourseRequest.getTutorId())).thenReturn(test);

        Mockito.doAnswer(invocation -> {
            Course testCourse = invocation.getArgument(0);
            Assertions.assertEquals(addCourseRequest.getTutorId(), testCourse.getTutor().getTutorId());
            return null;
        }).when(courseRepository).save(Mockito.any(Course.class));
        appService.addCourse(addCourseRequest);

    }

    @Test
    public void testAddStudent() {
        AddStudentRequest addStudentRequest = new AddStudentRequest("Peter", "Logs");
        List<Course> CoursesAttending = new ArrayList<>();
        Mockito.doAnswer(invocation -> {
            Student testStudent = invocation.getArgument(0);
            Assertions.assertEquals(addStudentRequest.getStudentName(), testStudent.getStudentName());
            Assertions.assertEquals(addStudentRequest.getStudentSurname(), testStudent.getStudentSurname());
            Assertions.assertEquals(testStudent.getCoursesAttending(), CoursesAttending);
            return null;
        }).when(studentRepository).save(Mockito.any(Student.class));
        appService.addStudent(addStudentRequest);
    }

    @Test
    public void testSearchStudentsCourses() {

        List<Student> studentList = new ArrayList<>();
        Tutor tutorForStudent = new Tutor(2L, "Tumbins", "Kastitis");
        Course courseForStudent = new Course(1L, "Geography", tutorForStudent, studentList);
        List<Course> coursesAttending = new ArrayList<>();
        coursesAttending.add(courseForStudent);

        Student testStudent = new Student(1L, "Austins", "Brillis", coursesAttending);

        Optional<Student> test = Optional.of(testStudent);
        when(studentRepository.findById(1L)).thenReturn(test);
        studentRepository.findById(1L);


        Assertions.assertEquals(courseForStudent, coursesAttending.get(0));

    }

    @Test
    public void testAddCourseToStudent() {
        Tutor tutorForStudent = new Tutor(1L, "Maisina", "Bildite");

        List<Student> studentList = new ArrayList<>();
        Course courseForStudent = new Course(2L, "Physics", tutorForStudent, studentList);

        List<Course> coursesAttending = new ArrayList<>();
        Student testStudent = new Student(1L, "Tumbins", "Cepumis", coursesAttending);

        Optional<Student> optionalTestStudent = Optional.of(testStudent);
        when(studentRepository.findById(1L)).thenReturn(optionalTestStudent);

        Optional<Course> optionalCourseForStudent = Optional.of(courseForStudent);
        when(courseRepository.findById(2L)).thenReturn(optionalCourseForStudent);

        appService.addCourseToStudent(2L, 1L);

    }
}
