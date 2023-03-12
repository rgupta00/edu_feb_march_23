package com.bankapp.model.exceptions;

public class BankAccountNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException(String message) {
		super(message);
	}
}
