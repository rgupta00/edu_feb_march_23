package com.bankapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.UserEnity;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEnity, Integer>{
	public UserEnity findByUsername(String username);
}
