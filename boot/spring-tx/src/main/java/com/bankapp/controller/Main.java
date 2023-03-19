package com.bankapp.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bankapp.config.AppConfig;
import com.bankapp.dao.Account;
import com.bankapp.service.AccountService;

public class Main {

	public static void main(String[] args) {
		//Problem is that programmer is maintaining the dep
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

		AccountService accountService=(AccountService) ctx.getBean("accService");
		 
	
		//accountService.transfer(1, 2, 10);

		accountService.addManyAccount();
		
	}
}
