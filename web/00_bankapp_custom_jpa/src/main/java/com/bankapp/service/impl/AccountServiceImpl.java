package com.bankapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.entities.Account;
import com.bankapp.repo.AccountRepo;
import com.bankapp.service.AccountService;

@Service(value = "accService")
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;

	@Override
	public List<Account> getAll() {
		return accountRepo.findAll();
	}

}
