package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Account;

public interface AccountService {

	public Account getAccount(int id);
	
	public Account getAccountById(int id, int id2);

	public List<Account> getAllAccounts();

	public Account updateAccount(Account change, int id, int id2);

	public Account deleteAccount(int id, int id2);
	
	public Account changeType(Account a);

	public Account addAccount(Account a, int id);
	
	public Account addCAccount(Account a);

	public List<Account> getAllSAccounts();

	public Account addSAccount(Account a);

	public List<Account> getAllAccountsById(int id, String amountLessThan, String amountGreaterThan);

	public Account depositWithdraw(Account a, int id, int id2);


}
