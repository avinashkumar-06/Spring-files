package org.avinashcodes.weatherforecast.controller;

import lombok.RequiredArgsConstructor;
import org.avinashcodes.weatherforecast.model.UserRecord;
import org.avinashcodes.weatherforecast.repository.UserRepository;
import org.avinashcodes.weatherforecast.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/weather/api")
public class LoginSignupController {

    private final UserService userService;
    private final UserRepository userRepo;

    @PostMapping("/signup")
    public ResponseEntity<UserRecord> signup(@RequestBody UserRecord userRecord){

        UserRecord savedUserRecord = userService.addUser(userRecord);
        return new ResponseEntity<>(savedUserRecord, HttpStatus.CREATED);
    }

    @GetMapping("/signin")
    public ResponseEntity<UserRecord> login(Authentication auth){
        System.out.println(auth);
        UserRecord customer= userRepo.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }



}
