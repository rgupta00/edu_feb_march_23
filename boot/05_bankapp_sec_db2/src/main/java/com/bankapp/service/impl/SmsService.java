package com.bankapp.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.bankapp.service.MessingService;

@Service
@Primary
public class SmsService implements MessingService{

	public void sendMessage() {
		System.out.println("sms is send...");
	}
}
