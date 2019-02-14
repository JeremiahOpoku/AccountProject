package com.qa.intergration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.repository.AccountService;
import com.qa.rest.AccountEndPoint;

@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointTest { 
	private static final String MOCK_VALUE2 = "test_value2";
	private static final String MOCK_VALUE = "test_value";

	@InjectMocks
	private AccountEndPoint endpoint;

	@Mock
	private AccountService svc;

	@Before
	public void setup() {
		endpoint.setService(svc); 
	}

	@Test
	public void testGetAllAccounts() {
		Mockito.when(svc.getAllAccounts()).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.getAllAccounts()); 
	}

	@Test
	public void testCreateAccount() {
		Mockito.when(svc.createAccount(MOCK_VALUE2)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.createAccount(MOCK_VALUE2));
		Mockito.verify(svc).createAccount(MOCK_VALUE2);
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(svc.deleteAccount(1L)).thenReturn(MOCK_VALUE);
		Assert.assertEquals(MOCK_VALUE, endpoint.deleteAccount(1L));
		Mockito.verify(svc).deleteAccount(1L);
	}
}
