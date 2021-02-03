package com.springboot.demo.exception;

public class AccountNotFoundExecption extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AccountNotFoundExecption(String message) {
		super(message);
	}
}
