package com.stuartkruze.controllers;


import java.util.List;


import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.stuartkruze.models.Account;
import com.stuartkruze.services.AccountService;
import com.stuartkruze.services.ClientService;

import io.javalin.http.Handler;


public class AccountController {
	
	AccountService as;
	ClientService cs;
	Gson gson = new Gson();
	
	final static Logger log = Logger.getLogger(ClientController.class);

	public AccountController(AccountService as) {
		this.as = as;
	}
	
	public Handler getAllAccounts = (context) -> {
		List<Account> accounts = as.getAllAccounts();
		context.result(gson.toJson(accounts));
		log.info("All Accounts Checked");
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
			log.info("Got account by Id");
		} else {
			context.status(404);
			log.error("Something went wrong getting account by Id");
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
			log.info("Got account by Id");
		} else {
			context.status(404);
			log.error("Something went wrong getting account by Id");
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
			log.info("Account Updated");
		} else {
			log.error("Account Update failed");
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
			log.info("Account Deleted");
		} else {
			context.status(404);
			log.info("Account Delete Failed");
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
			log.info("The Transaction was Completed ");

		} else {
			context.status(404);
			log.error("something went wrong completing your transaction");
		}
		
		if(a != null && a.isFail() == true){
			context.status(422);
			log.error("insufficient funds");
		}
		
	};
	
	public Handler transfer  = (context) -> {
		
		String input = context.pathParam("id");
		String input2 = context.pathParam("id2");
		String input3 = context.pathParam("id3");
		int id;
		int id2;
		int id3;
		try {
			id = Integer.parseInt(input);
			id2 = Integer.parseInt(input2);
			id3 = Integer.parseInt(input3);
			
		} catch (NumberFormatException e) {
			id = -1;
			id2 = -1;
			id3 = -1;
		}
		
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.transfer(a, id, id2, id3);
		
		
		if(a != null && a.isFail() == false) {
			context.result((a != null) ? gson.toJson(a) : "{}");
			log.info("The Transaction was Completed ");
		} else if(a != null && a.isFail() == true){
			context.status(422);
			log.error("insufficient funds");
		} else {
			context.status(404);
			log.error("something went wrong completing your transaction");
		}
		
	};
}
