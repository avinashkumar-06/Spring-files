package org.avinashcodes.weatherforecast.service.impl;

import lombok.RequiredArgsConstructor;
import org.avinashcodes.weatherforecast.exception.UserException;
import org.avinashcodes.weatherforecast.model.UserRecord;
import org.avinashcodes.weatherforecast.repository.UserRepository;
import org.avinashcodes.weatherforecast.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserRecord addUser(UserRecord userRecord) {

        Optional<UserRecord> userExistOrNot = userRepository.findByEmail(userRecord.getEmail());

        if(userExistOrNot.isPresent())
            throw new UserException("User Already Present with email id: "+userRecord.getEmail());

        userRecord.setPassword(passwordEncoder.encode(userRecord.getPassword()));
        return userRepository.save(userRecord);
    }

    @Override
    public UserRecord getUserByEmail(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(()->new UserException("No user found with email: "+email));
    }


}
