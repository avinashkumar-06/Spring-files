package com.avinashcodes.pathvariableandrequestparameterdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PathVariableController {

    @GetMapping("/get-user/{id}")
    public String getUserById(@PathVariable("id") Integer userId){

        return "User id: "+userId;
    }


}
