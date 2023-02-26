package com.bankapp.service;
//SOLID

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//HLM			LLM
/*
 * 
	<bean id="accService" class="com.bankapp.service.AccountService" autowire="byType">
	</bean>
 */

@Service(value = "accService")
public class AccountService {

	@Autowired
	@Qualifier("emailService")
	private MessingService messingServiceEmail;

	@Autowired
	@Qualifier("smsService")
	private MessingService messingServiceSms;
	
	
	public void transfer(int fromAcc, int toAcc, double amount) {

		System.out.println("fund is tranfered from acc " + fromAcc + " to " + toAcc + " and amount is " + amount);

		messingServiceEmail.sendMessage();
		messingServiceSms.sendMessage();

	}

}
