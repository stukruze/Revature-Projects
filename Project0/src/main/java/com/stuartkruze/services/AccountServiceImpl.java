package com.stuartkruze.services;

import java.util.List;

import com.stuartkruze.models.Account;
import com.stuartkruze.repositories.AccountRepo;

public class AccountServiceImpl implements AccountService {
	
	public AccountRepo ar;

	public AccountServiceImpl(AccountRepo ar) {
		this.ar = ar;
	}

	@Override
	public Account getAccount(int id) {
		return ar.getAccount(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		return ar.getAllAccounts();
	}

	@Override
	public Account addAccount(Account a) {
		return ar.addAccount(a);
	}

	@Override
	public Account updateAccount(Account change) {
		return ar.updateAccount(change);
	}

	@Override
	public Account deleteAccount(int id) {
		return ar.deleteAccount(id);
	}

}
