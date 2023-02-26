package com.bankapp.service;
//SOLID

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//HLM			LLM
/*
 * 
	<bean id="accService" class="com.bankapp.service.AccountService" autowire="byType">
	</bean>
 */

@Service(value = "accService")
public class AccountService {

	private MessingService messingService;

	@Autowired
	public void setMessingService(MessingService messingService) {
		this.messingService = messingService;
	}
	
	public void transfer(int fromAcc, int toAcc, double amount) {

		System.out.println("fund is tranfered from acc " + fromAcc + " to " + toAcc + " and amount is " + amount);

		messingService.sendMessage();

	}

}
