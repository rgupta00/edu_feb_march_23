package com.bankapp.service;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		//Problem is that programmer is maintaining the dep
		
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);

		AccountService accountService=(AccountService) ctx.getBean("accService");
		
		
		accountService.transfer(1, 2, 10);
		
		

		
	}
}
