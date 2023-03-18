package com.loginapp.service;

import com.loginapp.dao.User;
import com.loginapp.dao.UserDao;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isValid(User user) {
		return userDao.isValid(user);
	}
}
