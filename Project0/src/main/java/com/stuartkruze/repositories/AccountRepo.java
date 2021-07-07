package com.stuartkruze.repositories;

import java.util.List;

import com.stuartkruze.models.Account;

public interface AccountRepo {

	public Account getAccount(int id);
	
	public Account getAccountById(int id, int id2);
	
	public List<Account> getAllAccounts();
	
	public Account addAccount(Account a, int id);
	
	public Account updateAccount(Account change, int id, int id2);
	
	public Account deleteAccount(int id, int id2);

	public Account changeType(Account change);

	public List<Account> getAllCAccounts();

	public Account addCAccount(Account a);

	public Account addSAccount(Account a);
	
	public List<Account> getAllSAccounts();

	public List<Account> getAllSAccountsById(int id, String amountLessThan, String amountGreaterThan);

	public Account depositWithdraw(Account a, int id, int id2);	
	
}
