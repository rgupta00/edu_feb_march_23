package com.bankapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.entities.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		//Problem is that programmer is maintaining the dep
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

		AccountService accountService=(AccountService) ctx.getBean("accService");
		 
		//System.out.println(accountService.getClass());
		List<Account> accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));
//		
		
		accountService.transfer(2, 1, 100);
		
		accounts=accountService.getAll();
		accounts.forEach(a-> System.out.println(a));

		
	}
}
