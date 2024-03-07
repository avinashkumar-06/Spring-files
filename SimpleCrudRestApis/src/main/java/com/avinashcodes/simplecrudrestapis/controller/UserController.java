package com.avinashcodes.simplecrudrestapis.controller;


import com.avinashcodes.simplecrudrestapis.model.User;
import com.avinashcodes.simplecrudrestapis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {


    private UserService userService;


    @PostMapping()
    public ResponseEntity<User> saveUser(@RequestBody User user){

        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id){

        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> allUser = userService.getAllUser();
        return new ResponseEntity<>(allUser,HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Integer id,@RequestBody User user){

        User updatedUser = userService.updateUser(id,user);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Integer id){

        User deletedUser = userService.deleUser(id);
        return new ResponseEntity<>(deletedUser,HttpStatus.OK);

    }







}
