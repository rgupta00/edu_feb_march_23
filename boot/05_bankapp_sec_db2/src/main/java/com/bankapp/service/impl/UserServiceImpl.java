package com.bankapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankapp.dao.UserEntityRepo;
import com.bankapp.entities.UserEnity;
import com.bankapp.service.UserService;

import lombok.AllArgsConstructor;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserEntityRepo userEntityRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEnity findByUsername(String username) {
		return userEntityRepo.findByUsername(username);
	}

	@Override
	public void addUser(UserEnity userEnity) {

		userEnity.setPassword(passwordEncoder.encode(userEnity.getPassword()));

		userEntityRepo.save(userEnity);
	}

}
