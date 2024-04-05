package org.avinashcodes.weatherforecast.repository;

import org.avinashcodes.weatherforecast.model.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserRecord,Integer> {

    Optional<UserRecord> findByEmail(String email);

}
