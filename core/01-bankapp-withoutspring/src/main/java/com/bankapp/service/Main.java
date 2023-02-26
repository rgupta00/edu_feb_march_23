package com.bankapp.service;

public class Main {

	public static void main(String[] args) {
		//Problem is that programmer is maintaining the dep
		
		
		MessingService messingService=new SmsService();
		
		AccountService accountService=new AccountService();
		accountService.setMessingService(messingService);
		
		
		accountService.transfer(1, 2, 10);
	}
}
