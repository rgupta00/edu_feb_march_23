package com.bankapp.service;

import org.springframework.stereotype.Component;

//<bean id="ms2" class="com.bankapp.service.EmailService" />
@Component(value = "ms2")
public class EmailService implements MessingService{
	public void sendMessage() {
		System.out.println("email is send...");
	}
}
