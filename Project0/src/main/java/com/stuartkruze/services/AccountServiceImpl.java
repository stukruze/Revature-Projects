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
	public Account getAccountById(int id, int id2) {
		return ar.getAccountById(id, id2);
	}

	@Override
	public List<Account> getAllAccounts() {
		return ar.getAllAccounts();
	}

	@Override
	public Account addAccount(Account a, int id) {
		return ar.addAccount(a, id);
	}

	@Override
	public Account updateAccount(Account change, int id, int id2) {
		return ar.updateAccount(change, id, id2);
	}

	@Override
	public Account deleteAccount(int id, int id2) {
		return ar.deleteAccount(id, id2);
	}

	@Override
	public Account changeType(Account change) {
		return ar.changeType(change);
	}

	@Override
	public Account addCAccount(Account a) {
		return ar.addCAccount(a);
	}

	@Override
	public List<Account> getAllSAccounts() {
		return ar.getAllSAccounts();
	}

	@Override
	public Account addSAccount(Account a) {
		return ar.addSAccount(a);
	}

	@Override
	public List<Account> getAllAccountsById(int id, String amountLessThan, String amountGreaterThan) {
		return ar.getAllSAccountsById(id, amountLessThan, amountGreaterThan);
	}

	@Override
	public Account depositWithdraw(Account a, int id, int id2) {
		return ar.depositWithdraw(a, id, id2);
	}
}
