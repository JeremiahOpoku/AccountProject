package com.qa.service.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountDBRepository;
import com.qa.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountDBRepositoryTest { 
	@InjectMocks
	private AccountDBRepository repo;

	@Mock
	private EntityManager em;

	@Mock
	private Query query;

	private JSONUtil util;

	private static final String MOCK_DATA_ARRAY = "[{\"accountNumber\":\"12\",\"firstName\":\"g\",\"id\":1,\"lastName\":\"h\"}]";

	private static final String MOCK_OBJECT = "{\"accountNumber\": \"12\", \"firstName\":\"g\",\"id\":1,\"lastName\":\"h\"}";

	@Before
	public void setup() {
		repo.setManager(em);
		util = new JSONUtil();   
		repo.setUtil(util);
	}

	@Test
	public void testGetAllAccount() {
		
		Mockito.when(em.createQuery(Mockito.anyString())).thenReturn(query);
		
		List<Account> accounts = new ArrayList<Account>();
		
		Account anAcc = new Account("12","g","h");
		
		anAcc.setId(1L);
		 
		accounts.add(anAcc);
		
		//DUMMY
		Mockito.when(query.getResultList()).thenReturn(accounts);
		
		Assert.assertEquals(MOCK_DATA_ARRAY, repo.getAllAccounts());  
	}

	@Test
	public void testCreateAccount() {
		String reply = repo.createAccount(MOCK_OBJECT);
		Assert.assertEquals(reply, "{\"message\": \"Account has been sucessfully added\"}"); 
	} 
	
	@Test
	public void testDeleteAccount() {
		String reply = repo.deleteAccount(1L);
		Assert.assertEquals(reply, "{\"message\": \"Account has been sucessfully deleted\"}");
	
	}
}
