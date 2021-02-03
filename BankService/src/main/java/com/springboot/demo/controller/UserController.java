package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.exception.AccountNotFoundExecption;
import com.springboot.demo.model.Customer;
import com.springboot.demo.model.Transaction;
import com.springboot.demo.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired 
	UserServiceImpl userService;
	@Autowired
	Environment environment;
	@PostMapping("/register")
	public String register(@RequestBody Customer customer) {
		userService.registerUser(customer);
		return "Success";
	}

	@PostMapping("/fundtransafer")
	public String fundtransafer(@RequestParam String username,@RequestParam String fromAccountNumber,@RequestParam String toAccountNumber,@RequestParam Long amount) throws AccountNotFoundExecption {
		userService.fundtransafer(username,fromAccountNumber,toAccountNumber,amount);
		return "Success";
	}

	@PostMapping("/getTransactionsStatement")
	public List<Transaction> getTransactionsStatement(@RequestParam String username,@RequestParam String fromDate,@RequestParam String toDate) throws AccountNotFoundExecption {
		return userService.getTransactionsStatement(username,fromDate,toDate);
	}

	@GetMapping("/getPort")	
	public String getPort() {
		return environment.getProperty("server.port");
	}
}
