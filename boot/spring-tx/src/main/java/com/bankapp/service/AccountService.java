package com.bankapp.service;

import java.sql.SQLException;
import java.util.List;

import com.bankapp.dao.Account;

public interface AccountService {
	
	public List<Account> getAll();

	public void addAccount(Account account);

	public void deleteAccount(int id);

	public Account getById(int id);

	public void deposit(int accId, double amount);
	
	public void withdraw(int accId, double amount);
	
	public void transfer(int fromAcc, int toAcc, double amount) ;
	public void addManyAccount() ;
	
	public void addBatch(List<Account> accounts);
	
	
}
