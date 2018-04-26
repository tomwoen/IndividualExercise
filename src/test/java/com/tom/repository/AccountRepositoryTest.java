package com.tom.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.mockito.InjectMocks;

public class AccountRepositoryTest {

	@InjectMocks
	private AccountRepository repository;
	
	private Account account = new Account("Tom","Owen","1234");
	
	private String mock = "{\"firstName\":\"Tom\",\"secondName\":\"Owen\",\"accountNumber\":\"1234\"}";
	
	@Before
	public void setup() {
		
		repository = new AccountRepository();
				
	}
	
	@Test
	public void testGetAccount() {
		
		String actual = repository.getAccount(account);
		String expected = mock;
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testAddAccount() {
		
		String actual = repository.addAccount(account);
		String expected = "{\"message\":\"Account Successfully added\"}";
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testDeleteAccount() {
		
		String actual = repository.deleteAccount(account);
		String expected = "{\"message\":\"Account Successfully deleted\"}";
		assertEquals(expected, actual);
	
	}

}
