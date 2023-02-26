package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component(value = "ms1")
@Primary
public class SmsService implements MessingService{

	public void sendMessage() {
		System.out.println("sms is send...");
	}
}
