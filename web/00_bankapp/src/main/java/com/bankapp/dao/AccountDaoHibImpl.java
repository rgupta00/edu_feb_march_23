package com.bankapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.bankapp.entities.Account;

@Repository
@Primary
public class AccountDaoHibImpl implements AccountDao {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Account> getAll() {
		return em.createQuery("select a from Account a", Account.class).getResultList();
	}

	@Override
	public Account getById(int id) {
		return em.find(Account.class, id);
	}

	@Override
	public Account updateAccount(Account account) {
		em.merge(account);// merge() vs update()
		return account;
	}

	@Override
	public Account addAccount(Account account) {
		em.persist(account);
		return account;
	}

	@Override
	public Account deleteAccount(int id) {
		Account accToDelete = getById(id);
		if (accToDelete != null) {
			em.remove(accToDelete);
		}
		return accToDelete;

	}

}
