package com.bankapp.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.AccountRepo;
import com.bankapp.entities.Account;
import com.bankapp.exceptions.BankAccountNotFoundException;
import com.bankapp.service.AccountService;
import com.bankapp.service.MessingService;
@Service(value = "accService")
@Transactional
public class AccountServiceImpl implements AccountService {

	private MessingService messingService;

	private AccountRepo accountDao;
	
	public AccountServiceImpl(MessingService messingService, AccountRepo accountDao) {
		this.messingService = messingService;
		this.accountDao = accountDao;
	}


	public void transfer(int fromAccId, int toAccId, BigDecimal amount) {
		Account fromAcc = getById(fromAccId);
		Account toAcc = getById(toAccId);

		fromAcc.setBalance(fromAcc.getBalance().subtract(amount));
		toAcc.setBalance(toAcc.getBalance().add(amount));

		accountDao.save(fromAcc);
		
		accountDao.save(toAcc);

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
		return accountDao.findAll();
	}

	@Override
	public Account addAccount(Account account) {
		return accountDao.save(account);
	}

	@Override
	public Account deleteAccount(int id) {
		Account accountToDelete= getById(id);
		 accountDao.delete(accountToDelete);
		 return accountToDelete;
	}

	@Override
	public Account getById(int id) {
		return accountDao.findById(id).orElseThrow(() -> new BankAccountNotFoundException("bank account with id :"+ id +" is not found"));
	}

	@Override
	public void deposit(int accId, BigDecimal amount) {

		Account acc = getById(accId);

		acc.setBalance(acc.getBalance().add(amount));

		accountDao.save(acc);

		System.out.println("fund is deposited to account " + accId + " and amount" + amount);
	}

	@Override
	public void withdraw(int accId, BigDecimal amount) {
		Account acc = getById(accId);

		acc.setBalance(acc.getBalance().subtract(amount));

		accountDao.save(acc);

		System.out.println("fund is withdraw to account " + accId + " and amount" + amount);
	}


	@Override
	public Account updateAccount(int id, Account account) {
		Account accountToUpdate= getById(id);
		accountToUpdate.setName(account.getName());
		accountDao.save(accountToUpdate);
		return accountToUpdate;
	}

}
