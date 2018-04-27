package com.tom.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import com.tom.persistence.Account;
import com.tom.util.JSONUtil;

public class JSONUtilTest {
	
	@Inject
	private JSONUtil jUtil;
	private Account account;
	private Account expected;
	private Account actual;
	

	@Before
	public void setUp() {
		
		jUtil = new JSONUtil();
		
	}
	
	@Test
	public void testGetJSONForObject() {
		
		account = new Account("Bill","Billson","1111");
		String actual = jUtil.getJSONForObject(account);
		String expected = "{\"firstName\":\"Bill\",\"lastName\":\"Billson\",\"accountNumber\":\"1111\"}";		
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetObjectForJSON() {
		
		expected = new Account("Phil", "Mitchell","1234");
		actual = jUtil.getObjectForJSON("{\"firstName\":\"Phil\",\"lastName\":\"Mitchell\",\"accountNumber\":\"1234\"}");
		assertEquals(expected, actual);
	}

}
