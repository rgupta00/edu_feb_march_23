package com.bankapp.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.model.dao.AccountDao;
import com.bankapp.model.entities.Account;
import com.bankapp.model.exceptions.BankAccountNotFoundException;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.MessingService;
@Service(value = "accService")
@Transactional
public class AccountServiceImpl implements AccountService {

	private MessingService messingService;

	private AccountDao accountDao;
	
	public AccountServiceImpl(MessingService messingService, AccountDao accountDao) {
		this.messingService = messingService;
		this.accountDao = accountDao;
	}


	public void transfer(int fromAccId, int toAccId, double amount) {
		Account fromAcc = accountDao.getById(fromAccId);
		Account toAcc = accountDao.getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance() - amount);
		toAcc.setBalance(toAcc.getBalance() + amount);

		accountDao.updateAccount(fromAcc);
		accountDao.updateAccount(toAcc);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("fund is tranfered from acc " + fromAcc + " to " + toAcc + " and amount is " + amount);
		messingService.sendMessage();
		
	}

	@Override
	public List<Account> getAll() {
//		if(1==1)
//			throw new RuntimeException("now spend day and night to solve it");
		
		return accountDao.getAll();
	}

	@Override
	public void addAccount(Account account) {
		// want to apply validation on account
		// tx sec, logging
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
	public void update(Account account) {
		accountDao.updateAccount(account);
	}

}
