package com.avinashcodes.simplecrudrestapis.repository;

import com.avinashcodes.simplecrudrestapis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {



}
