package com.tom.util;

import com.google.gson.Gson;
import com.tom.persistence.Account;

public class JSONUtil {
	
	private Gson json;
	
	public JSONUtil () {
		
		this.json = new Gson();
	}

	public String getJSONForObject(Object Obj) {
		return json.toJson(Obj);
	}

	public Account getObjectForJSON(String jSON) {
		return json.fromJson(jSON, Account.class);
	}

}
