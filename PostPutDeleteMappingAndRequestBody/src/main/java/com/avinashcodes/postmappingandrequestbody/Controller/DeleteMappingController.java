package com.avinashcodes.postmappingandrequestbody.Controller;


import com.avinashcodes.postmappingandrequestbody.bean.Student;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteMappingController {


    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(Integer studentID){

        // In real world we have to write logic for deleting resource in database.

        return "student deleted with id: "+studentID;
    }



}
