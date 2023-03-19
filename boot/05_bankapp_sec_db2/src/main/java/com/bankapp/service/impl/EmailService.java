package com.bankapp.service.impl;

import org.springframework.stereotype.Service;

import com.bankapp.service.MessingService;
@Service
public class EmailService implements MessingService{
	public void sendMessage() {
		System.out.println("email is send...");
	}
}
