package com.bankapp.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;

import com.bankapp.entities.Account;

public interface AccountService {
	
	//@Secured({"ROLE_MGR","ROLE_CLERK"})
	//@PreAuthorize("hasAuthority('ROLE_MGR') and hasAuthority('ROLE_CLERK')")
	public List<Account> getAll();
	
	public Account updateAccount(int id, Account account);


	public Account addAccount(Account account);

	public Account deleteAccount(int id);

	//https://www.concretepage.com/spring/spring-security/preauthorize-postauthorize-in-spring-security
//	@PostAuthorize ("returnObject.name == authentication.name")
	//@PostAuthorize("returnObject.name=authentication.name")
	//@Secured({"ROLE_MGR"})
	public Account getById(int id);

	public void deposit(int accId, BigDecimal amount);
	
	public void withdraw(int accId, BigDecimal amount);
	
	public void transfer(int fromAcc, int toAcc, BigDecimal amount);
}
