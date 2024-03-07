package com.avinashcodes.simplecrudrestapis.service.impl;

import com.avinashcodes.simplecrudrestapis.model.User;
import com.avinashcodes.simplecrudrestapis.repository.UserRepository;
import com.avinashcodes.simplecrudrestapis.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    /*
      Since only the parametrized constructors will be present, we can ignore @Autowired
      But, If the no args constructors were present then we had to annotate this with @Autowired.
    */





    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        return userRepository.save(user);

    }

    @Override
    public User getUserById(Integer id) {

        //   I am not handling exception where the id provided doesn't exist in the database.

        Optional<User> foundUser =  userRepository.findById(id);
        return foundUser.get();

    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();

    }

    @Override
    public User updateUser(Integer id, User user) {

        //   I am not handling exception where the id provided doesn't exist in the database.

        Optional<User> optionalUser = userRepository.findById(id);
        User userToUpdate = optionalUser.get();
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setName(user.getName());
        return userRepository.save(userToUpdate);

    }

    @Override
    public User deleUser(Integer id) {

        //   I am not handling exception where the id provided doesn't exist in the database.

        Optional<User> optionalUser = userRepository.findById(id);
        User userToDelete =  optionalUser.get();
        userRepository.delete(userToDelete);
        return userToDelete;

    }


}
