package com.bankapp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;
@Repository
@Primary
public class AccountDaoHibImpl implements AccountDao{
	
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public AccountDaoHibImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getSession() {
		return sessionFactory.getCurrentSession();//getCurrentSession vs openSession
	}

	@Override
	public List<Account> getAll() {
		return getSession().createQuery("select a from Account a",Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return getSession().get(Account.class, id);
	}

	@Override
	public void updateAccount(Account account) {
		getSession().merge(account);//merge() vs update()
	}

	@Override
	public void addAccount(Account account) {
		getSession().save(account);
	}

	@Override
	public void deleteAccount(int id) {
		Account accToDelete= getById(id);
		if(accToDelete!=null) {
			getSession().delete(accToDelete);
		}
		
	}

}















