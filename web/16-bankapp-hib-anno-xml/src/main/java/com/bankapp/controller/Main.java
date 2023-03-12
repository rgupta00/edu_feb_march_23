package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		// Problem is that programmer is maintaining the dep

		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

		AccountService accountService = (AccountService) ctx.getBean("accService");

		try {
			Account a1 = new Account("seema kumari from banglore", 1000);
			// Account a2=new Account("ravi", 1000);

			accountService.addAccount(a1);
		} catch (DataAccessException ex) {
				System.out.println("handled");
		}
//		accountService.addAccount(a2);

		// System.out.println(accountService.getClass());
//		List<Account> accounts=accountService.getAll();
//		accounts.forEach(a-> System.out.println(a));
////		
//		
//		accountService.transfer(2, 1, 100);
//		
//		accounts=accountService.getAll();
//		accounts.forEach(a-> System.out.println(a));

	}
}
