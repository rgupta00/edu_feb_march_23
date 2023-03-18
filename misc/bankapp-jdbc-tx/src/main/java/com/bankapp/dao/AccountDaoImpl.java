package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Primary
public class AccountDaoImpl implements AccountDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Account> getAll() {
		 return jdbcTemplate.query("select * from account2", new AccountRowMapper());
	}

	@Override
	public Account getById(int id) {
		return jdbcTemplate.queryForObject("select * from account2 where id=?", new AccountRowMapper(), id);
	}

	@Override
	public void updateAccount(Account account) {
		jdbcTemplate.update("update account2 set balance=? where id=?",
				new Object[] {account.getBalance(), account.getId()});
	}

	
	@Override
	public void addAccount(Account account) {
		System.out.println("method start: addAccount");
		jdbcTemplate.update("insert into account2(name,balance) values(?,?)",
				new Object[] {account.getName(), account.getBalance()});
		
		System.out.println("account saved");
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("detete from account2 where id=?",id);
	}

}








