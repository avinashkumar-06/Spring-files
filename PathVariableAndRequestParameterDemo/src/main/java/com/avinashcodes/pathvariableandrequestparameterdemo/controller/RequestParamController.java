package com.avinashcodes.pathvariableandrequestparameterdemo.controller;


import com.avinashcodes.pathvariableandrequestparameterdemo.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestParamController {

    // uri : - http://localhost:8080/student/search?roll=11&name=avinash&city=blr
    // Here method parameter name and  variable name in uri template is same
    @GetMapping("student/search")
    public Student getStudent(@RequestParam Integer roll,
                              @RequestParam String name,
                              @RequestParam String city){




        return new Student(roll,name,city);



    }


    // uri :- http://localhost:8080/student/search1?roll=11&name=avinash&city=blr
    // Here method parameter name and  variable name in uri template is different
    @GetMapping("student/search1")
    public Student getStudent1(@RequestParam("roll") Integer rollNo,
                              @RequestParam("name") String fullName,
                              @RequestParam("city") String permanentCity){




        return new Student(rollNo,fullName,permanentCity);



    }




}
