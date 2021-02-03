package com.usk.foodservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usk.foodservice.feignclient.BankServiceClient;
import com.usk.foodservice.model.FoodIteam;
import com.usk.foodservice.model.FoodOrder;
import com.usk.foodservice.model.User;
import com.usk.foodservice.service.FoodOrderServiceImpl;


@RestController
public class FoodOrderServiceController {
	@Autowired
	private FoodOrderServiceImpl foodOrderService;
	
	@Autowired
	BankServiceClient bankServiceClient;
	@GetMapping("searchItem")
	public List<FoodIteam> searchItem(@RequestParam String itemname) {
		return foodOrderService.searchItem(itemname);
		
	}

	@PostMapping("placeOrder")
	public String placeOrder(@RequestBody FoodOrder order) throws Exception {
		return foodOrderService.placeOrder(order);
		
	}
	
	@PostMapping("getOrderListByUser")
	public List<FoodOrder> getOrderListByUser(@RequestBody User user) throws Exception {
		return foodOrderService.getOrderListByUser(user);
		
	}
	@GetMapping("getPort")
	public String getPort() {
		return bankServiceClient.getPort();
		
	}

}
