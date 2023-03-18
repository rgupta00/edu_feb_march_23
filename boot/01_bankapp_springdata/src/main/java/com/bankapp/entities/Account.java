package com.bankapp.entities;

import java.math.BigDecimal;

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
@Table(name = "accounts_table_new_table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "acc_id")
	private int id;
	
	@Column(name = "acc_holder_name")
	private String name;
	
	@Column(name = "acc_balance")
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
