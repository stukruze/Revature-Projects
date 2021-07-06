package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Account;

public interface AccountService {

	public Account getAccount(int id);

	public List<Account> getAllAccounts();

	public Account addAccount(Account a);

	public Account updateAccount(Account change);

	public Account deleteAccount(int id);
	
	public Account changeType(Account a);

}
