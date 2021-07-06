package com.stuartkruze.controllers;

import java.util.List;

import com.google.gson.Gson;
import com.stuartkruze.models.Account;
import com.stuartkruze.models.Client;
import com.stuartkruze.services.AccountService;

import io.javalin.http.Handler;


public class AccountController {
	
	AccountService as;
	Gson gson = new Gson();

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
	
	public Handler addAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	
	public Handler updateAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.updateAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	
	public Handler deleteAccount = (context) -> {
		String input = context.pathParam("id");
		int id;
		try {
			id = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			id = -1;
		}
		
		Account a = as.deleteAccount(id);
		
		context.result((a != null) ? gson.toJson(a) : "{}");
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
		
		a = as.addAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	
	public Handler getAllSAccounts = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};
	public Handler addSAccount = (context) -> {
		Account a = gson.fromJson(context.body(), Account.class);
		
		a = as.addAccount(a);
		context.result((a != null) ? gson.toJson(a) : "{}");
	};

}
