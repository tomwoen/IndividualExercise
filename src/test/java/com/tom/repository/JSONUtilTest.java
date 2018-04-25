package com.tom.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;

import com.tom.persistence.Account;

public class JSONUtilTest {
	
	@Inject
	private Account account;
	

	@Test
	public void testGetJSONForObject() {
		
		
		String actual = getJSONForObject(account ("Bill","Billson","1111"));
		
		
		assertEquals(expected,actual);
	}

}
