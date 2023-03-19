package com.bankapp.config;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankapp.entities.UserEnity;


public class SecUser implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private UserEnity userEnity;
	
	public SecUser(UserEnity userEnity) {
		this.userEnity = userEnity;
	}
	
	

	public UserEnity getUserEnity() {
		return userEnity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> namesList=userEnity.getRoles();
		
		String names[]=namesList.toArray(new String[namesList.size()]);
		
		return AuthorityUtils.createAuthorityList(names);
	}

	
	
	@Override
	public String getPassword() {
		return userEnity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEnity.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
