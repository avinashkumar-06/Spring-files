package com.avinashcodes.simplecrudrestapis.service;

import com.avinashcodes.simplecrudrestapis.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Integer id);
    List<User> getAllUser();
    User updateUser(Integer id,User user);
    User deleUser(Integer id);

}
