package com.qa.persistence.repository;

public interface AccountRepository {

	String getAllAccounts();
	String getAAcount(Long id);
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String account);

}
