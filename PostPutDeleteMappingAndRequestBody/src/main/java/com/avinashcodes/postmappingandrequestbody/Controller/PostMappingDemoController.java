package com.avinashcodes.postmappingandrequestbody.Controller;


import com.avinashcodes.postmappingandrequestbody.bean.Course;
import com.avinashcodes.postmappingandrequestbody.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostMappingDemoController {

    @PostMapping("/student/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){

        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    // This is how you should  manage if you need  to take two objects from a  single request body
    // Create a  dto which will have both class objects and use request body to bind the coming json to that
    //   and then get individual class objects separately.

    @PostMapping("/student/create/both")
    public ResponseEntity<StudentAndCourse> createStudentCourse(@RequestBody StudentAndCourse object){

        Student student = object.getStudent();
        Course course = object.getCourse();

        System.out.println(student);
        System.out.println(course);
        return new ResponseEntity<>(object,HttpStatus.CREATED);
    }




}

class StudentAndCourse{

    private Student student;
    private Course course;

    public StudentAndCourse() {
    }

    public StudentAndCourse(Student student, Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
