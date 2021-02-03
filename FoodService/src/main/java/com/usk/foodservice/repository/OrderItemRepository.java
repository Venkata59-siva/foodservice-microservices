package com.usk.foodservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.foodservice.model.OrderIteam;

public interface  OrderItemRepository extends JpaRepository<OrderIteam, Long> {

}
