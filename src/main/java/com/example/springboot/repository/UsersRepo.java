package com.example.springboot.repository;

import com.example.springboot.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepo extends JpaRepository<Users, Integer> {

    Users findByLogin(String login);

}
