package com.qa.rest;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.business.repository.AccountService;

@Path("/account")
public class AccountEndPoint {

	@Inject
	AccountService svc;

	@Path("/getAllAccounts")
	@GET
	@Produces("application/json")
	public String getAllAccounts() {
		return svc.getAllAccounts(); 
	}
	
	@Path("/getAAccount/{id}")
	@GET
	@Produces({"application/json"})
	public String getAAccount(@PathParam("id") Long id) {
		return svc.getAAcount(id);
	}

	@Path("/createAccount")
	@GET
	@Produces({"application/json"})
	public String createAccount(@PathParam("account")String account) {
		return svc.createAccount(account);   
	}
	
	@Path("/deleteAccount")
	@GET
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id") Long id) {
		return svc.deleteAccount(id); 
	}
	
	@Path("updateAccount")
	@GET
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") Long id, String account) {
		return svc.updateAccount(id, account);
	}
	public void setService(AccountService svc ) {
		this.svc = svc;
	}
}
