package com.avinashcodes.firstassignment.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/api/greeting")
    public ResponseEntity<String> helloWorld(){

        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }



}
