package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bankapp.dto.Account;

@RestController
public class AccountRestClientController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "accountbyi")
	public Account getById() {
		Account account=restTemplate.getForObject("http://localhost:8090/bankapp/api/accounts/1", Account.class);
		
		return account;
	}

}
