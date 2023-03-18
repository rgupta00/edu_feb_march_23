package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import com.bankapp.entities.Account;

public interface AccountService {
	
	public List<Account> getAll();
	
	public Account updateAccount(int id, Account account);


	public Account addAccount(Account account);

	public Account deleteAccount(int id);

	public Account getById(int id);

	public void deposit(int accId, BigDecimal amount);
	
	public void withdraw(int accId, BigDecimal amount);
	
	public void transfer(int fromAcc, int toAcc, BigDecimal amount);
}
