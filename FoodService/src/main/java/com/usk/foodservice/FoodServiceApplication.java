package com.usk.foodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@RibbonClient("com.usk.foodservice.config")
public class FoodServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(FoodServiceApplication.class, args);
	}

}
