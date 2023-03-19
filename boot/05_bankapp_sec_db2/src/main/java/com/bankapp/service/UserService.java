package com.bankapp.service;

import com.bankapp.entities.UserEnity;

public interface UserService {
	public UserEnity findByUsername(String username);
	public void addUser(UserEnity userEnity);
}
