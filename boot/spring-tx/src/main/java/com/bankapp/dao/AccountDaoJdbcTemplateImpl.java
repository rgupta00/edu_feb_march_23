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

@Repository
@Primary
public class AccountDaoJdbcTemplateImpl implements AccountDao{

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public AccountDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
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
		jdbcTemplate.update("insert into account2(name,balance) values(?,?)",
				new Object[] {account.getName(), account.getBalance()});
	}

	@Override
	public void deleteAccount(int id) {
		jdbcTemplate.update("detete from account2 where id=?",id);
	}

}








