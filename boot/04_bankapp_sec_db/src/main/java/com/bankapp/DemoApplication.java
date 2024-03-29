package com.bankapp;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bankapp.entities.Account;
import com.bankapp.entities.UserEnity;
import com.bankapp.service.AccountService;
import com.bankapp.service.UserService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		//init the things
		
		accountService.addAccount(new Account("aman",new BigDecimal(1000), "aman@gmail.com","5534345555"));
		accountService.addAccount(new Account("suman",new BigDecimal(1000), "suman@gmail.com","5530045555"));
		System.out.println("--------------added---------------");
		
		userService.addUser(new UserEnity("raj", "raj123", List.of("ROLE_MGR","ROLE_CLERK")));
		userService.addUser(new UserEnity("ekta", "ekta123", List.of("ROLE_CLERK")));
		
		
	}

}
