# StudentApp
## Description

Welcome to my StudentApp!

Code is written using Java 17, Spring Boot version 2.7.5 as a framework, and Maven as a build tool.

Code includes swagger and Unit tests

This code is for an app, that can add to the H2 database :
*Tutor, Course, and Student*

And contains functions that can -> *add courses to student*  and  *get the list of all courses and their tutors, that this student
is attending by students id*

## Setup
Clone this project: `git clone git@github.com:ElinaLastovska/StudentApp.git`

## How it works?
### Swagger
When you have started the app. You can use swagger, to see how it works.
> To use swagger go to this link -> http://localhost:8080/swagger-ui/index.html#/
### H2 console
When you have started the app. You can use the H2 console, to see all tables and use other functions.
> To use H2 console go to this link -> http://localhost:8080/h2-console/
## What next?
#### First start with adding a tutor.
To add Tutor you need to indicate `tutorName` and `tutorSurname` as String values, as shown in json example.

> ID generates automatically by H2

```
{
  "tutorName": "string",
  "tutorSurname": "string"
}
```
And it will save to the H2 tutor object ->
```
{
  "tutorId": 0,
  "tutorName": "string",
  "tutorSurname": "string"
}
```


#### After that, you can add a course. 
To add Course you need to indicate `name` as String value and `tutorId` as Long. See in json example.

> ID generates automatically by H2

```
{
  "name": "string",
  "tutorId": 0
}
```
And it will save to the H2 tutor object ->
```
  {
  "courseId": 0,
  "courseName": "string",
  "tutor": {
    "tutorId": 0,
    "tutorName": "string",
    "tutorSurname": "string"
  }
 }
```
As you can see, this object is a bit more complex. But no worries! It just looks that way! 

The course just has `Course name`, `Course ID` and `Tutor` that is teaching it!
It will add Tutor automatically by the ID that you give (If it exists) but students in the list `studentsAttending` you can add later!

#### And finally you can add a student.
To add Student you need to indicate `studentName` and `studentName` as String values, as shown in json example.

> ID generates automatically by H2

```
{
  "studentName": "string",
  "studentName": "string"
}
```
And it will save to the H2 student object ->
```
{
  "coursesAttending": [
    {
      "courseId": 0,
      "courseName": "string",
      "tutor": {
        "tutorId": 0,
        "tutorName": "string",
        "tutorSurname": "string"
      }
    }
  ],
  "studentId": 0,
  "studentName": "string",
  "studentSurname": "string"
}
```
This is similar to the course object!
It Contains `StudentId`, `studentName`, `studentSurname`, and a list of `coursesAttending` that contains info about Courses and Tutors that teaches these Courses!

## Let's do something with these objects!
We have 2 functions -> `add-course-to-student` and `searchStudentsCourses`

I think that you could guess what those do from function names.
But let me explain!

#### add-course-to-student
You need to give the existing `courseId` and existing `studentId`, as shown in json example.
```
{
  "courseId": 0,
  "studentId": 0
}
```
This function will add this course to the students' list of `coursesAttending`.
#### searchStudentsCourses
You need to give the existing `studentId` that you want to find.
This function will get the list of all courses and their tutors, that this student
is attending.
