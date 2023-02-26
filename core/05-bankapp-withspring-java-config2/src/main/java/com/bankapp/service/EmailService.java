package com.bankapp.service;

import org.springframework.stereotype.Component;

public class EmailService implements MessingService{
	public void sendMessage() {
		System.out.println("email is send...");
	}
}
