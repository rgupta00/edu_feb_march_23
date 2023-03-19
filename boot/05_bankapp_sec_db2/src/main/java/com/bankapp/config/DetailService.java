package com.bankapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bankapp.entities.UserEnity;
import com.bankapp.service.UserService;

@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEnity userEnity = userService.findByUsername(username);

		if (userEnity == null) {
				throw new UsernameNotFoundException("login failed");
		}
		// somehow i need to convert this userEnity to the object that spring sec
		// understand
		// userEnity--> object that extends a class UserDetails
		return new SecUser(userEnity);
	}

}
