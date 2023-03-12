package com.bankapp.web.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.model.entities.Account;
import com.bankapp.model.service.AccountService;

@RestController
@RequestMapping(value = "api")
public class RestAccountController {

	private AccountService accountService;

	@Autowired
	public RestAccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = "accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAll();
	}

	

}











