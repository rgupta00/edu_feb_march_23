package com.bankapp.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

public class SmsService implements MessingService{

	public void sendMessage() {
		System.out.println("sms is send...");
	}
}
