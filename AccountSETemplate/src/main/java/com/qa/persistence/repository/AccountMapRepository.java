package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Alternative;

import com.qa.persistence.domain.Account;
import com.qa.util.JSONUtil;

@Alternative
public class AccountMapRepository implements AccountRepository {

	private JSONUtil util = new JSONUtil();

	Map<Long, Account> accountMap = new HashMap<Long, Account>();


	public String getAllAccounts() {
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		Account secondAccount = util.getObjectForJSON(account, Account.class);  

		accountMap.put(secondAccount.getId(), secondAccount);
		return "Account Created";
	}

	public String deleteAccount(Long id) {
		accountMap.remove(id);
		return null;
	}
 
	public String updateAccount(Long id, String account) {
		deleteAccount(id);
		createAccount(account);
		return "Account Updated"; 
	}


	public int checkName(String nameInAccount) {
		return (int) accountMap.values().stream().filter(n->n.getFirstName().contentEquals(nameInAccount)).count(); 
			
	}


	@Override
	public String getAAcount(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
