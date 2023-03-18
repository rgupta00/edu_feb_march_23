package com.loginapp.model.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImplHib implements UserDao {

	@Override
	public boolean isValid(User user) {
		System.out.println("----------LoginServiceImpl Hibernate---------");
		if (user.getUserName().equals(user.getPassword()))
			return true;
		else
			return false;
	}

}
