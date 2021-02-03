package com.springboot.demo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Table(name = "ACCOUNT_TYPE")
public class AccountType {
    @Column(name ="ACCOUNT_TYPE_ID")
    @Id @GeneratedValue(strategy=GenerationType.AUTO)
	public String accountTypeId;
    @Column(name ="ACCOUNT_TYPE")
	public String accountType;

	public String getAccountTypeId() {
		return accountTypeId;
	}

	public void setAccountTypeId(String accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
