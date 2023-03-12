package com.bankapp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO 
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "accounts_table_new")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id")
	private int id;
	
	@Column(name = "acc_holder_name", length = 20)
	private String name;
	
	@Column(name = "acc_balance")
	private double balance;

	public Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	
	
}
