package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

import java.util.Collection;
import java.util.*;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

@Default
@Transactional(SUPPORTS)
public class AccountDBRepository implements AccountRepository { 

	@Inject
	private JSONUtil util;
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
 
	@Override
	public String getAllAccounts() {
		Query query = em.createQuery("Select a FROM Account a");
		Collection<Account> accounts = (Collection<Account>) query.getResultList();
		return util.getJSONForObject(accounts);  
  
	}

	@Transactional(REQUIRED)
	@Override
	public String createAccount(String account) {
		Account aAccount = util.getObjectForJSON(account, Account.class);
		em.persist(aAccount);
		return "{\"message\": \"Account has been sucessfully added\"}"; 
	}

	@Transactional(REQUIRED)
	@Override
	public String deleteAccount(Long id) {
		em.remove(em.find(Account.class, id)); 
		return "{\"message\": \"Account has been sucessfully deleted\"}";
	}

	@Transactional(REQUIRED)
	@Override
	public String updateAccount(Long id, String account) {
		deleteAccount(id);
		createAccount(account);
		return "{\"message\": \"Account has been sucessfully updated\"}"; 
	}

	@Override
	public String getAAcount(Long id) {
		return util.getJSONForObject(em.find(Account.class, id));
	}

	public void setManager(EntityManager em) {
		this.em = em;
	}
	public void setUtil(JSONUtil util) {
		this.util = util;
	}

	
	
}


