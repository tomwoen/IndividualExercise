package com.tom.repository;

import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;

import com.tom.persistence.Account;
import com.tom.util.JSONUtil;


public class AccountRepository implements IAccountRepository {
	
	@PersistenceContext(unitName="primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil jUtil;
	
	
	public String getAccount(Long id) {
		Account getAccount = findAccount(id);
		
		if (getAccount != null) {
			
			return jUtil.getJSONForObject(getAccount);
		}
		else {
			return "{\"message\":\"Account Not Found\"}";
		}
		
	}

	private Account findAccount(Long id) {
		return manager.find(Account.class, id);
	}
	
	public String getAllAccounts() {
		Query query = manager.createQuery("Select a FROM Account a");
		Collection <Account> allaccounts = (Collection <Account>) query.getResultList();
		return jUtil.getJSONForObject(allaccounts);
	}

	@Transactional(REQUIRED)
	public String addAccount(String jSON) {
		Account newAccount = jUtil.getObjectForJSON(jSON);
		manager.persist(newAccount);
		return "{\"message\":\"Account Successfully Added\"}";
	}

	@Transactional(REQUIRED)
	public String updateAccount(Long id, String newJSON) {
		Account old = findAccount(id);
		Account update = jUtil.getObjectForJSON(newJSON);
		
		if (old !=null) {
			old = update;
			manager.merge(old);
			return "{\"message\":\"Account Successfully Updated\"}";
		}
		else {
			return "{\"message\":\"Account Not Found\"}";
		}
		
	}
	
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		
		Account delete = findAccount(id);
		
		if (delete != null) {
			
			manager.remove(delete);
			return "{\"message\":\"Account Successfully deleted\"}";
		}
		else {
			return "{\"message\":\"Account Not Found\"}";
		}
	}
	
	public void setManager(EntityManager manager) {
		this.manager = manager;
	} 
	
	public void setUtil(JSONUtil jUtil) {
		this.jUtil = jUtil;
	}


	

}
