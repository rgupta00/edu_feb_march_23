package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//Qualifer annotation
//<bean id="ms2" class="com.bankapp.service.EmailService" />
// emailService
@Service(value = "emailService")
public class EmailService implements MessingService{
	public void sendMessage() {
		System.out.println("email is send...");
	}
}
