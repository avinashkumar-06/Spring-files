package com.avinashcodes.postmappingandrequestbody.Controller;


import com.avinashcodes.postmappingandrequestbody.bean.Course;
import com.avinashcodes.postmappingandrequestbody.bean.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PutMappingDemoController {


    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student){

        // In real world we have to write logic for updating resource in database.

        return student;
    }

    // PutMapping with @PathVariable

    @PutMapping("/student/update/{id}")
    public Course updateCourse(@RequestBody Course course,@PathVariable("id") Integer courseID){

        System.out.println(courseID);

        // In real world we have to write logic for updating resource in database.

        return course;
    }








}
