package com.bankapp.service;

import org.springframework.stereotype.Component;

@Component(value = "ms2")
public class EmailService implements MessingService{
	public void sendMessage() {
		System.out.println("email is send...");
	}
}
