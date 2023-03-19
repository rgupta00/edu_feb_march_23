package com.bankapp.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO 
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Account {
	
	private int id;
	
	private String name;
	
	private BigDecimal balance;

	private String email;
	
	private String phone;

	public Account(String name, BigDecimal balance, String email, String phone) {
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.phone = phone;
	}
	
	


}
