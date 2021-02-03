package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.demo.model.Customer;

public interface UserRepostitory extends JpaRepository<Customer, String>{

	Customer findByUsername(String username);



}
