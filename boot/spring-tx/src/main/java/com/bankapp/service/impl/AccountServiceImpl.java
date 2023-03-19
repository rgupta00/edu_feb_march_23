package com.bankapp.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.Account;
import com.bankapp.dao.AccountDao;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.service.AccountService;
@Service(value = "accService")
/*
 * noRollbackFor = {NullPointerException.class}	rollbackFor = {SQLException.class}
 */
@Transactional		
//explicit vs declartively :) AOP around advice
public class AccountServiceImpl implements AccountService {

	private AccountDao accountDao;
	
	
	public AccountServiceImpl(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void transfer(int fromAccId, int toAccId, double amount){
		Account fromAcc = accountDao.getById(fromAccId);
		Account toAcc = accountDao.getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);
		
		
		
		accountDao.updateAccount(toAcc);

		
		System.out.println("fund is tranfered from acc " + fromAcc + " to " + toAcc + " and amount is " + amount);
	
		
	}

	@Override
	public List<Account> getAll() {
//		if(1==1)
//			throw new RuntimeException("now spend day and night to solve it");
		
		return accountDao.getAll();
	}

	//add many account
	@Transactional(propagation = Propagation.REQUIRED)
	public void addManyAccount() {
		System.out.println("------------addManyAccount started-------------");
		for(int i=0;i<=10;i++) {
			accountDao.addAccount(new Account("name "+ i , 1000.00 ));
		
		}
		System.out.println("------------addManyAccount end-------------");
	}
	
	
	@Override
	public void addAccount(Account account) {
		accountDao.addAccount(account);
	}

	@Override
	public void deleteAccount(int id) {
		accountDao.deleteAccount(id);
	}

	@Override
	public Account getById(int id) {

		Account account = accountDao.getById(id);

		if (account == null) {
			throw new BankAccountNotFoundException("bank account is not found");
		}
		return account;
	}

	@Override
	public void deposit(int accId, double amount) {

		Account acc = accountDao.getById(accId);

		acc.setBalance(acc.getBalance() + amount);

		accountDao.updateAccount(acc);

		System.out.println("fund is deposited to account " + accId + " and amount" + amount);
	}

	@Override
	public void withdraw(int accId, double amount) {
		Account acc = accountDao.getById(accId);

		acc.setBalance(acc.getBalance() - amount);

		accountDao.updateAccount(acc);

		System.out.println("fund is withdraw to account " + accId + " and amount" + amount);
	}

	@Override
	public void addBatch(List<Account> accounts) {
		
	
	}

}









