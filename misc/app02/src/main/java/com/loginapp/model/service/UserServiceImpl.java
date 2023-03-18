package com.loginapp.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loginapp.model.dao.User;
import com.loginapp.model.dao.UserDao;
import com.loginapp.model.dao.UserDaoImplJdbc;
@Service(value = "userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public boolean isValid(User user) {
		return userDao.isValid(user);
	}
}
