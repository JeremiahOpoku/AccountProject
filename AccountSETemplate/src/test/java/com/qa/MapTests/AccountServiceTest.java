package com.qa.MapTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.qa.persistence.repository.AccountMapRepository;

public class AccountServiceTest {
	
	private AccountMapRepository acc;
	private static final String MOCK_OBJECT = "{\"id\": 1, \"account_number\": \"12\", \"first_name\": \"h\",\" last_name\":\" h\"}";

	@Before
	public void setup() {
		acc = new AccountMapRepository(); 
	
	}
	
	@Test
	public void addAccountTest() {	
		String reply = acc.createAccount(MOCK_OBJECT);
		Assert.assertEquals(reply,"Account Created");
	}
	
	@Test
	@Ignore
	public void add2AccountsTest() {
		fail("TODO");	
	} 

	@Test
	@Ignore
	public void removeAccountTest() {
		fail("TODO");	
	}
	
	@Test
	@Ignore
	public void remove2AccountsTest() {
		fail("TODO");	
	}
	
	@Test
	@Ignore
	public void remove2AccountTestAnd1ThatDoesntExist() {
		fail("TODO");	
	}
	
	@Test
	@Ignore
	public void jsonStringToAccountConversionTest() {
		// testing JSONUtil
		fail("TODO");	
	}


	@Test
	@Ignore
	public void accountConversionToJSONTest() {
		//testing JSONUtil
		fail("TODO");	 
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
		String input1 = acc.createAccount(MOCK_OBJECT);
		String input2 = acc.createAccount(MOCK_OBJECT);
		
		Assert.assertEquals(1, acc.checkName("h"));
	}
	
	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenOne() {
		String input1 = acc.createAccount(MOCK_OBJECT);
		String input2 = acc.createAccount(MOCK_OBJECT); 
		Assert.assertEquals(1, acc.checkName("g"));
		

	}

	@Test
	@Ignore
	public void getCountForFirstNamesInAccountWhenTwo() {
		String input1 = acc.createAccount(MOCK_OBJECT);
		String input2 = acc.createAccount(MOCK_OBJECT);
		String input3 = acc.createAccount(MOCK_OBJECT);
		String input4 = acc.createAccount(MOCK_OBJECT);
		assertEquals(2,acc.checkName("g")); 
	}

}
