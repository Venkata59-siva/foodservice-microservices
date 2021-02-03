package com.springboot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
	

	Account findByAccountNumber(String accountNumber);

	@Query(value = "select a.* from ACCOUNT a  where a.ACCOUNT_NUMBER = :fromAccountNumber and a.customer_id = :customerId", nativeQuery = true)
	Account findByAccountNumberAndCustomer(@Param("fromAccountNumber") String fromAccountNumber,@Param("customerId") Long customerId);
}
