package com.example.springsecurityjpa;

import com.example.springsecurityjpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDetailsRepositoy  extends JpaRepository<User,Long> {

    Optional<User> findByUserName(String UserName);
}