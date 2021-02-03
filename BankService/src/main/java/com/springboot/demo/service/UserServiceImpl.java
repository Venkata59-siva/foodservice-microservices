package com.springboot.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.exception.AccountNotFoundExecption;
import com.springboot.demo.model.Account;
import com.springboot.demo.model.Customer;
import com.springboot.demo.model.Transaction;
import com.springboot.demo.repository.AccountRepository;
import com.springboot.demo.repository.TransactionRepository;
import com.springboot.demo.repository.UserRepostitory;

@Service
public class UserServiceImpl {
	@Autowired
	UserRepostitory useRepository;
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;

	public Customer registerUser(Customer customer) {
		
		/*
		 * Account account=new Account(); account.setAccountNumber("0123");
		 * List<Account> accounts=new ArrayList<Account>(); accounts.add(account);
		 * customer.setAccounts(accounts);
		 */
		return useRepository.save(customer);
	}

	@Transactional
	public String  fundtransafer(String username,String fromAccountNumber, String toAccountNumber, Long amount) throws AccountNotFoundExecption {
		//boolean isfromExist=accountRepository.findByAccountNumberAndUsername(username,fromAccountNumber);
		Customer customer=useRepository.findByUsername(username);
		Account toAccount=accountRepository.findByAccountNumber(toAccountNumber);
		Account fromAccount=accountRepository.findByAccountNumberAndCustomer(fromAccountNumber,customer.getCustomerId());
		boolean canTransafer =true;
		if( customer==null) {
			canTransafer=false;
			throw new AccountNotFoundExecption("Customer Not Found");
		}
		if(toAccount==null) {
			canTransafer=false;
			throw new AccountNotFoundExecption("Credit Account Not Found");
		}
		if(fromAccount == null) {
			canTransafer=false;
			throw new AccountNotFoundExecption("Credit Account Not Found");
	    }
		
		if(amount > fromAccount.getBalance()) {
			canTransafer=false;
			throw new AccountNotFoundExecption("Insufficient Amount in Debit account");
		}
		
  if(canTransafer)		{
	  fromAccount.setBalance(fromAccount.getBalance()-amount);
	  accountRepository.save(fromAccount);
	  toAccount.setBalance(toAccount.getBalance()+amount);
	  accountRepository.save(toAccount);
	  Transaction transaction=new Transaction();
	  transaction.setDebitAccountNo(fromAccountNumber);
	  transaction.setCreditAccountNo(toAccountNumber);
	  transaction.setTransactionType("DEBITED");
	  transaction.setTransAmount(amount);
	  transaction.setTransactionDate(LocalDate.now());
	  transaction.setCustomer(customer);
	  transactionRepository.save(transaction);
	  
	   
  }
		
		return "Order placed Successfully";
}

	public List<Transaction> getTransactionsStatement(String username, String fromDate, String toDate) {
		// TODO Auto-generated method stub
		Customer customer=useRepository.findByUsername(username);
		return transactionRepository.getTransactionsStatement(LocalDate.parse(fromDate),LocalDate.parse(toDate),customer.getCustomerId());
	}

	
	
}
