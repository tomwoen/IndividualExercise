package com.tom.persistence;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long ID;
	private String firstName;
	private String lastName;
	@Size(min=4, max=4)
	private String accountNumber;
	
	public Account () {
		
	}
	
	public Account (String firstName, String lastName, String accountNumber) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}

	public Long getID() {
		return ID;
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

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	

}
