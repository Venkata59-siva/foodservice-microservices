package com.springboot.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.demo.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    @Query("from Transaction t where t.transactionDate between :fromDate and :toDate and  t.customer.customerId=:customerId")
	List<Transaction> getTransactionsStatement(@Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate, @Param("customerId") Long customerId);

}
