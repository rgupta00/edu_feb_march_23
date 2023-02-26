package com.bankapp.service;
//SOLID

//HLM			LLM
public class AccountService {

	private MessingService messingService;

	public void setMessingService(MessingService messingService) {
		this.messingService = messingService;
	}

	public void transfer(int fromAcc, int toAcc, double amount) {

		System.out.println("fund is tranfered from acc " + fromAcc + " to " + toAcc + " and amount is " + amount);

		messingService.sendMessage();

	}

}
