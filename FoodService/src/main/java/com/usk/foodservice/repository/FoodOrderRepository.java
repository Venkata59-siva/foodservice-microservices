package com.usk.foodservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usk.foodservice.model.FoodIteam;

public interface FoodOrderRepository extends JpaRepository<FoodIteam, Long>{
	  @Query("select u from FoodIteam u where u.itemName like %?1%")
	public List<FoodIteam> findByItemNameContaining(String itemName);

	public FoodIteam findByItemName(String string);

}
