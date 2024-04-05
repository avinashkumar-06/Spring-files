package org.avinashcodes.weatherforecast.service;

import org.avinashcodes.weatherforecast.model.UserRecord;

public interface UserService{

    UserRecord addUser(UserRecord userRecord);
    UserRecord getUserByEmail(String email);

}
