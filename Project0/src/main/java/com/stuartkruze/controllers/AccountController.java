package com.stuartkruze.controllers;


import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.stuartkruze.models.Account;
import com.stuartkruze.models.Client;
import com.stuartkruze.services.AccountService;


import io.javalin.http.Handler;


public class AccountController {
	
	AccountService as;
	Gson gson = new Gson();
	
	final static Logger log = Logger.getLogger(ClientController.class);

	public AccountController(AccountService as) {
		this.as = as;
	}
	
	public Handler getAllAccounts = (context) -> {
		List<Account> accounts = as.getAllAccounts();
		context.result(gson.toJson(accounts));
	};
	
	public Handler getAccountById = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		Account a = as.getAccount(id);
		
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			context.status(400);
		}
		
	};
	
	public Handler getAccountById2 = (context) -> {
		String input = context.pathParam("id");
		String input2 = context.pathParam("id2");
		int id;
		int id2;
		try {
			id = Integer.parseInt(input);
			id2 = Integer.parseInt(input2);
			
		} catch (NumberFormatException e) {
			id = -1;
			id2 = -1;
		}
		Account a = as.getAccountById(id, id2);
		
		
		if(a != null) {
			context.result(gson.toJson(a));
		} else {
			context.status(404);
		}
		
	};
	
	public Handler addAccount = (context) -> {
		
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addAccount(a, id);
		
		if (a != null) {
			context.result((a != null) ? gson.toJson(a) : "{}");
			context.status(201);
			log.info("Account Created");
		} else {
			context.status(500);
			log.error("something went wrong creating an account");
		}
		
		
		
		
	};
	
	public Handler updateAccount = (context) -> {
		
		String input = context.pathParam("id");
		String input2 = context.pathParam("id2");
		int id;
		int id2;
		try {
			id = Integer.parseInt(input);
			id2 = Integer.parseInt(input2);
			
		} catch (NumberFormatException e) {
			id = -1;
			id2 = -1;
		}
		
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.updateAccount(a, id, id2);
		
		if(a != null) {
			context.result((a != null) ? gson.toJson(a) : "{}");
		} else {
			context.status(404);
		}
		
	};
	
	public Handler deleteAccount = (context) -> {
		
		String input = context.pathParam("id");
		String input2 = context.pathParam("id2");
		int id;
		int id2;
		try {
			id = Integer.parseInt(input);
			id2 = Integer.parseInt(input2);
			
		} catch (NumberFormatException e) {
			id = -1;
			id2 = -1;
		}
		
		Account a = as.deleteAccount(id, id2);
		
		if(a != null) {
			context.result((a != null) ? gson.toJson(a) : "{}");
		} else {
			context.status(404);
		}
	};
	
	public Handler changeType = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.changeType(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	public Handler getAllCAccounts = (context) -> {
		List<Account> accounts = as.getAllAccounts();
		context.result(gson.toJson(accounts));
	};
	
	public Handler addCAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addCAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	
	public Handler getAllSAccounts = (context) -> {
		List<Account> accounts = as.getAllSAccounts();
		context.result(gson.toJson(accounts));
	};
	public Handler addSAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addSAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};

	public Handler getAllAccountsById = (context) -> {
		
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		String amountLessThan = context.queryParam("amountLessThan");
		String amountGreaterThan = context.queryParam("amountGreaterThan");
		
		
		List<Account> accounts = as.getAllAccountsById(id, amountLessThan, amountGreaterThan);
		
		Account a = as.getAccount(id);
		
		if (a != null) {
			context.result(gson.toJson(accounts));
			log.info("got all accounts from client " + id);
		} else {
			context.status(404);
			log.error("something went wrong searching for accounts");
		}
		
	};
	public Handler depositWithdraw  = (context) -> {
		
		String input = context.pathParam("id");
		String input2 = context.pathParam("id2");
		int id;
		int id2;
		try {
			id = Integer.parseInt(input);
			id2 = Integer.parseInt(input2);
			
		} catch (NumberFormatException e) {
			id = -1;
			id2 = -1;
		}
		
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.depositWithdraw(a, id, id2);
		
		if(a != null) {
			context.result((a != null) ? gson.toJson(a) : "{}");
		} else {
			context.status(404);
		}
	};
}
