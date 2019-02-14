package com.qa.business.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;
import com.qa.util.JSONUtil;
import java.util.*;


public class AccountServiceImpl implements AccountService { 

	@Inject 
	private AccountRepository repo;
	@Inject
	private JSONUtil util;
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	
	public String getAAcount(Long id) {
		return repo.getAAcount(id);
	}

	
	public String createAccount(String account) {
		Account anAccount = util.getObjectForJSON(account, Account.class);
		if (anAccount.getAccountNumber().contains("9")) {
			return "{\"message\": \"Can't add this Account\"}"; 
		}else 
			return repo.createAccount(account);
	}

	
	public String deleteAccount(Long id) {
		repo.deleteAccount(id);
		return "{\"message\": \"Account has been succesfully deleted\"}";
	}

	
	public String updateAccount(Long id, String account) {
		repo.deleteAccount(id);
		repo.createAccount(account);
		return "{\"message\": \"Account has been successfully updated\"}";
	}
}
