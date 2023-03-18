package com.loginapp.model.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserDaoImplJdbc implements UserDao {

	@Override
	public boolean isValid(User user) {
		System.out.println("----------LoginServiceImpl jdbc---------");
		if (user.getUserName().equals(user.getPassword()))
			return true;
		else
			return false;
	}

}
