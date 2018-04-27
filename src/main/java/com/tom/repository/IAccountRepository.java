package com.tom.repository;

public interface IAccountRepository {
	
	String getAccount(Long id);
	String addAccount(String jSON);
	String updateAccount(Long id, String newJSON);
	String deleteAccount(Long id);
	String getAllAccounts();

}
