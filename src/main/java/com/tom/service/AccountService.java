package com.tom.service;

import javax.inject.Inject;

import com.tom.repository.IAccountRepository;

public class AccountService implements iAccountService {

	@Inject
	IAccountRepository iRepository;
	
	@Override
	public String getAccount(Long id) {
		
		return iRepository.getAccount(id);
	}

	@Override
	public String addAccount(String jSON) {
		
		return iRepository.addAccount(jSON);
	}

	@Override
	public String updateAccount(Long id, String newJSON) {
		
		return iRepository.updateAccount(id,newJSON);
	}

	@Override
	public String deleteAccount(Long id) {
	
		return iRepository.deleteAccount(id);
	}

	@Override
	public String getAllAccounts() {
		
		return iRepository.getAllAccounts();
	}

}
