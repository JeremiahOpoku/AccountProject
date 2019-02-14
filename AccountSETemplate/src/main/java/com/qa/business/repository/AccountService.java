package com.qa.business.repository;

public interface AccountService {

	String getAllAccounts();
	String getAAcount(Long id);
	String createAccount(String account);
	String deleteAccount(Long id);
	String updateAccount(Long id, String account);
}
