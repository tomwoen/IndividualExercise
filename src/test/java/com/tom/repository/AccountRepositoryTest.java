package com.tom.repository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.tom.persistence.Account;
import com.tom.util.JSONUtil;

@RunWith(MockitoJUnitRunner.class)
public class AccountRepositoryTest {

	@InjectMocks
	private AccountRepository repository;
	
	@Mock
	private JSONUtil jUtil;
	
	@Mock
	private EntityManager manager;
	
	@Mock
	private Query query;
	
	
	private Account account = new Account("Tom","Owen","1234");
	
	private String mock = "{\"firstName\":\"Tom\",\"lastName\":\"Owen\",\"accountNumber\":\"1234\"}";
	
	private String mockdata = "[{\"firstName\":\"Tom\",\"lastName\":\"Owen\",\"accountNumber\":\"1234\"}]";
	
	
	
	@Before
	public void setup() {
		
		repository.setManager(manager);
		jUtil = new JSONUtil();
		repository.setUtil(jUtil);
						
	}
	
	@Test
	public void testAddAccount() {
		
		String actual = repository.addAccount(mock);
		String expected = "{\"message\":\"Account Successfully Added\"}";
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetAllAccounts() {
		
		Mockito.when(manager.createQuery(Mockito.anyString())).thenReturn(query);
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(account);
		Mockito.when(query.getResultList()).thenReturn(accounts);
		assertEquals(mockdata, repository.getAllAccounts());
	}
	
	@Test
	public void testGetAccount() {
		
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(account);
		String actual = repository.getAccount(1L);
		String expected = mock;
		assertEquals(expected, actual);
		
	}
	
	
	@Test
	public void testDeleteAccount() {
		
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(account);
		String actual = repository.deleteAccount(1L);
		String expected = "{\"message\":\"Account Successfully deleted\"}";
		assertEquals(expected, actual);
	
	}
	
	@Test
	public void testUpdateAccount() {
		
		Mockito.when(manager.find(Mockito.eq(Account.class), Mockito.anyLong())).thenReturn(account);
		String actual = repository.updateAccount(1L, mock);
		String expected = "{\"message\":\"Account Successfully Updated\"}";
		assertEquals(expected, actual);
	}

}
