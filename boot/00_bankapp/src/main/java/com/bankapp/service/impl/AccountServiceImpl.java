package com.bankapp.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.AccountDao;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.service.AccountService;
import com.bankapp.service.MessingService;
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
	public Account addAccount(Account account) {
		return accountDao.addAccount(account);
	}

	@Override
	public Account deleteAccount(int id) {
		return accountDao.deleteAccount(id);
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
	public Account updateAccount(int id, Account account) {
		Account accountToUpdate= getById(id);
		accountToUpdate.setName(account.getName());
		accountDao.updateAccount(accountToUpdate);
		return accountToUpdate;
	}

}
