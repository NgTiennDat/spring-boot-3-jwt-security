package com.datien.jwtsecurity.repository;

import com.datien.jwtsecurity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findAllByEmail(String email);

}
