package com.tom.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.tom.service.iAccountService;

@Path("/accounts")
public class AccountEndpoint {

	@Inject
	private iAccountService iService;
	
	@GET
	@Path("/json")
	@Produces({"application/json"})
	public String getAllAccounts() {
		
		return iService.getAllAccounts();
	}
	
	@GET
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String getAnAccount(@PathParam("id") Long id) {
		
		return iService.getAccount(id);
	}
	
	@POST
	@Path("/json")
	@Produces({"application/json"})
	public String addAccount(String jSON) {
		
		return iService.addAccount(jSON);
	}
	
	@POST
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") Long id, String newJSON){
		
		return iService.updateAccount(id, newJSON);
	}
	
	@DELETE
	@Path("/json/{id}")
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id) {
		
		return iService.deleteAccount(id);
	}
}
