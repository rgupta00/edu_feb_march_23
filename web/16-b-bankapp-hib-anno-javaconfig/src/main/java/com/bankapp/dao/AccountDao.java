package com.bankapp.dao;

import java.util.List;

import com.bankapp.entities.Account;

public interface AccountDao {
	public List<Account> getAll();
	
	public Account getById(int id);
	
	public void updateAccount(Account account);
	
	public void addAccount(Account account);
	
	public void deleteAccount(int id);
}
