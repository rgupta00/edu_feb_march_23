package com.bankapp.model.entities;

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
@Table(name = "accounts_table_new2")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id")
	private int id;
	
	@Column(name = "acc_holder_name", length = 20)
	private String name;
	
	@Column(name = "acc_balance")
	private double balance;

	@Column(name = "acc_holder_email")
	private String email;
	
	@Column(name = "acc_holder_phone")
	private String phone;
	
	public Account(String name, double balance, String email, String phone) {
		super();
		this.name = name;
		this.balance = balance;
		this.email = email;
		this.phone = phone;
	}
	

	
}
