package com.tom.service;

import com.tom.repository.IAccountRepository;

public class AccountService implements iAccountService {

	@Inject
	IAccountRepository iRepository;
	
	
	public String getAccount(Long id) {
		
		return iRepository.getAccount(id);
	}

	public String addAccount(String jSON) {
		
		return iRepository.addAccount(jSON);
	}

	public String updateAccount(Long id, String newJSON) {
		
		return iRepository.updateAccount(id,newJSON);
	}

	public String deleteAccount(Long id) {
	
		return iRepository.deleteAccount(id);
	}

	public String getAllAccounts() {
		
		return iRepository.getAllAccounts();
	}

}
