package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Account {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@Column(length = 6)
	private String accountNumber;
	@Column(name = "FirstName",length = 100)
	private String firstName;
	@Column(name = "LastName", length = 100)
	private String lastName;
	
	
	
	public Account() {
	}
	
	
	public Account(String accountNumber, String firstName, String lastName) { 
		super();
		this.accountNumber = accountNumber; 
		this.firstName = firstName;
		this.lastName = lastName; 
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;  
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName; 
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	
}
