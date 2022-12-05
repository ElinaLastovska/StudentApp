# StudentApp
## Description

Welcome to my StudentApp!

Code is written using Java 17, Spring Boot verion 2.7.5 as a framework and Maven as a build tool.

Code includes swagger and Unit tests

This code is for app, that can add to H2 database :
*Tutor, Course and Student*

And contains function taht can *get the list of all courses and their tutors, that this student
is attending by students id*

## Requirements
?Java?NodeJs?kādu vietu kur atvērt kodu?

## Setup
Clone this project: `git clone git@github.com:ElinaLastovska/StudentApp.git`

## How it works?
### Swagger
When you have started app. You can use swagger, to see how it works.
> To use swagger go to this link -> http://localhost:8080/swagger-ui/index.html#/
### H2 console
When you have started app. You can use H2 console, to see all tables and use other functions.
> To use H2 console go to this link -> http://localhost:8080/h2-console/
## What next?
#### First start with adding tutor.
To add Tutor you need to idicate `tutorName` and `tutorSurname` as String values, as shown in json example.

> ID generates automaticly by H2

```
{
  "tutorName": "string",
  "tutorSurname": "string"
}
```
And it will save to H2 tutor object ->
```
{
  "tutorId": 0,
  "tutorName": "string",
  "tutorSurname": "string"
}
```


#### After that you can add course. 
To add Course you need to idicate `name` as String value and `tutorId` as Long. see  in json example.

> ID generates automaticly by H2

```
{
  "name": "string",
  "tutorId": 0
}
```
And it will save to H2 tutor object ->
```
  {
  "courseId": 0,
  "courseName": "string",
  "studentsAttending": [
    {
      "coursesAttending": [
        null
      ],
      "studentId": 0,
      "studentName": "string",
      "studentSurname": "string"
    }
  ],
  "tutor": {
    "tutorId": 0,
    "tutorName": "string",
    "tutorSurname": "string"
  }
 }
```
As you can see, this objeckt is a bit more complex. But no worries! It jsut looks that way! 

Course just have `Course name`, `Course ID`, List of Students that are attending this course as `studentsAttending` and `Tutor` that is teaching it!
It will add Tutor atomaticly by ID that you gaive (If it exists) but students in list `studentsAttending` you can add later!

#### And atlast you can add student.
To add Student you need to idicate `studentName` and `studentName` as String values, as shown in json example.

> ID generates automaticly by H2

```
{
  "studentName": "string",
  "studentName": "string"
}
```
And it will save to H2 student object ->
```
{
  "coursesAttending": [
    {
      "courseId": 0,
      "courseName": "string",
      "studentsAttending": [
        null
      ],
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
This is simmilar as Course object!
It Contains `StudentId`, `studentName`, `studentSurname` and list of `coursesAttending` that contains info about Courses and Tutors that teaches these Courses!
