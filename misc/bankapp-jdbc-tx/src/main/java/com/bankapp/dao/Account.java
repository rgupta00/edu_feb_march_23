package com.bankapp.dao;

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
	private double balance;
	
	public Account(String name, double balance) {
		super();
		this.name = name;
		this.balance = balance;
	}

	
}
