package com.springboot.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name = "TRANSACTION")
@Entity
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_num_generator")
	@SequenceGenerator(name = "transaction_num_generator", sequenceName = "transaction_num_seq", allocationSize = 50)
	private Long transactionId;
	@Column(name = "DEBIT_ACCOUNTNO")
	private String debitAccountNo;
	@Column(name = "CREDIT_ACCOUNTNO")
	private String creditAccountNo;
	
	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;
	
	@Column(name = "TRANS_AMOUNT")
	private Long transAmount;
	@Column(name = "TRANSACTION_DATE")
	private LocalDate transactionDate;
	@ManyToOne(optional=false,fetch = FetchType.LAZY) 
    @JoinColumn(name="CUSTOMER_ID", nullable=false, updatable=false)
	private Customer customer;
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getDebitAccountNo() {
		return debitAccountNo;
	}
	public void setDebitAccountNo(String debitAccountNo) {
		this.debitAccountNo = debitAccountNo;
	}
	public String getCreditAccountNo() {
		return creditAccountNo;
	}
	public void setCreditAccountNo(String creditAccountNo) {
		this.creditAccountNo = creditAccountNo;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(LocalDate transactionDate) {
		this.transactionDate = transactionDate;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Long getTransAmount() {
		return transAmount;
	}
	public void setTransAmount(Long transAmount) {
		this.transAmount = transAmount;
	}
	
}
