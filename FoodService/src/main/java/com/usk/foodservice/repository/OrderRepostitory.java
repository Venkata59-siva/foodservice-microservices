package com.usk.foodservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usk.foodservice.model.FoodOrder;
import com.usk.foodservice.model.User;

public interface OrderRepostitory extends JpaRepository<FoodOrder, Long>{

	List<FoodOrder> findByOrderBy(User user);
	

}
