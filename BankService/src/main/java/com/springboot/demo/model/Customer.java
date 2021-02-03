package com.springboot.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table(name = "CUSTOMER")
public class Customer {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "CUSTOMER_ID")
public Long customerId;

@Column(name = "USER_NAME")
public String username;


@Column(name = "EMAIL")
public String email;

@Column(name = "MOBILE")
public String mobile ;


@OneToMany(orphanRemoval=true,cascade =CascadeType.ALL )
@JoinColumn(name = "CUSTOMER_ID",insertable = true)
public List<Account> accounts;

public Long getCustomerId() {
	return customerId;
}
public void setCustomerId(Long customerId) {
	this.customerId = customerId;
}
public List<Account> getAccounts() {
	return accounts;
}
public void setAccounts(List<Account> accounts) {
	this.accounts = accounts;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
}
