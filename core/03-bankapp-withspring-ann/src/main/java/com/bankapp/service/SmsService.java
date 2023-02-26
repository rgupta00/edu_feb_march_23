package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//	<bean id="ms1" class="com.bankapp.service.SmsService" primary="true"/>
@Service(value = "ms1")
@Profile(value = "test")
public class SmsService implements MessingService{

	public void sendMessage() {
		System.out.println("sms is send...");
	}
}
