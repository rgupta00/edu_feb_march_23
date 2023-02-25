package com.bankapp.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Problem is that programmer is maintaining the dep
		
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");

		AccountService accountService=(AccountService) ctx.getBean("accService");
		
		
		accountService.transfer(1, 2, 10);
		
		

		
	}
}
