package com.usk.foodservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.foodservice.model.User;

public interface UserServiceRepository extends JpaRepository<User, Long> {
public  Optional<User> findByUserName(String username);
}
