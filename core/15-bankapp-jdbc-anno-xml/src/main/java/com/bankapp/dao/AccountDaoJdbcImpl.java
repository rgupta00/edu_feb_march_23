package com.bankapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AccountDaoJdbcImpl implements AccountDao{

	@Autowired
	private DataSource dataSource;
	
	
	@Override
	public List<Account> getAll() {
	
		 List<Account> accountsList=new ArrayList<Account>();
		 
		try{
			//PreparedStatement vs Statement vs CallableStatement
			Connection connection=dataSource.getConnection();
			PreparedStatement pstmt=connection.prepareStatement("select * from account2");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				accountsList.add(new Account(rs.getInt(1), rs.getString(2), rs.getDouble(3)));
			}
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		return accountsList;
	}

	@Override
	public Account getById(int id) {
		return null;
	}

	@Override
	public void updateAccount(Account account) {
		
	}

	@Override
	public void addAccount(Account account) {
		
	}

	@Override
	public void deleteAccount(int id) {
		
	}

}
