package com.example.facebook.repo;

import com.example.facebook.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {


    User findUserByEmail(String email);
}