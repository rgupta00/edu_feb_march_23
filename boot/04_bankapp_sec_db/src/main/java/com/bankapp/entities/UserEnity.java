package com.bankapp.entities;

import java.util.*;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_table")
public class UserEnity {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	private String username;
	
	
	private String password;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="user_roles")
	private List<String>roles=new ArrayList<String>();

	public UserEnity(String username, String password, List<String> roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = roles;
	}
	
	
}





















