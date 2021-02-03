package com.usk.foodservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="http://BANKSERVICE/user")
public interface BankServiceClient {
	@PostMapping("/fundtransafer")
	public String fundtransafer(@RequestParam String username,@RequestParam String fromAccountNumber,@RequestParam String toAccountNumber,@RequestParam Long amount) throws Exception ;
    @GetMapping("/getPort")
	public String getPort();
}
