package com.usk.foodservice.service;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.usk.foodservice.exception.FoodIteamNotAvailable;
import com.usk.foodservice.feignclient.BankServiceClient;
import com.usk.foodservice.model.FoodIteam;
import com.usk.foodservice.model.FoodOrder;
import com.usk.foodservice.model.OrderIteam;
import com.usk.foodservice.model.User;
import com.usk.foodservice.repository.FoodOrderRepository;
import com.usk.foodservice.repository.OrderItemRepository;
import com.usk.foodservice.repository.OrderRepostitory;
import com.usk.foodservice.repository.UserServiceRepository;

@Service
public class FoodOrderServiceImpl {
	@Autowired
	private FoodOrderRepository foodOrderRepository;
	@Autowired
	UserServiceRepository userServiceRepository;
    @Autowired
	OrderRepostitory orderRepostitory;
    @Autowired
    private OrderItemRepository itemRepository;
    @Autowired
    BankServiceClient bankServiceClient;
    @Value("${vendor.accountnum}")
    private String vendorAccountNum;
	public List<FoodIteam> searchItem(String itemname) {
		List<FoodIteam> foodIteams=foodOrderRepository.findByItemNameContaining(itemname);
		foodIteams.forEach(foodieam-> System.out.println("Food item==" +foodieam.getItemName()));
		return foodIteams;
	}

	@Transactional
	public String placeOrder(FoodOrder order) throws Exception {
		// TODO Auto-generated method stub
		Optional<User> user=userServiceRepository.findByUserName(order.getOrderBy().getUserName());
		Long orderPrice=0L;
		for (FoodIteam foodIteam : order.getFoodIteams()) {
			FoodIteam fooditemdb=foodOrderRepository.findByItemName(foodIteam.getItemName()); 
              if(fooditemdb!=null) {
            	  foodIteam.setPrice(fooditemdb.getPrice());
            	  foodIteam.setItemId(fooditemdb.getItemId());
            	  System.out.println("price:"+foodIteam.getPrice());
            	  System.out.println("quantity:"+ foodIteam.getQuntity());
            	  Long price=foodIteam.getPrice()*foodIteam.getQuntity();
            	  orderPrice= orderPrice+price;
            	 // orderPrice=orderPrice+(foodIteam.getPrice()*foodIteam.getQuntity());
              }else {
            	  throw new FoodIteamNotAvailable("Iteam : "+foodIteam.getItemName()+" Not available");
              }
	}
		order.setOrderAmount(orderPrice);
		order.setOrderBy(user.get());
		order.setOrderDate(Date.valueOf(LocalDate.now()));
		orderRepostitory.save(order);
		for (FoodIteam fooditeam :  order.getFoodIteams()) {
			 //FoodIteam fooditemdb=foodOrderRepository.findByItemName(fooditeam.getItemName()); 
			 OrderIteam orderIteam=new OrderIteam();
				orderIteam.setFoodOrder(order);
				orderIteam.setItemId(fooditeam.getItemId());
				orderIteam.setPrice(new BigInteger(fooditeam.getPrice().toString()).multiply(new BigInteger(fooditeam.getQuntity().toString())).longValue());
				orderIteam.setQuantity(fooditeam.getQuntity());
				itemRepository.save(orderIteam);
		 }
		
		System.out.println("vendorAccountNum:"+vendorAccountNum);
		return bankServiceClient.fundtransafer(user.get().getUserName(), user.get().getAccount(), vendorAccountNum, orderPrice);
	}

	public List<FoodOrder> getOrderListByUser(User user) {
		// TODO Auto-generated method stub
		return orderRepostitory.findByOrderBy(user);
	}
	
	

}
