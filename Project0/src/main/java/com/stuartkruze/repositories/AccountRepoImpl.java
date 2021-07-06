package com.stuartkruze.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.stuartkruze.models.Account;
import com.stuartkruze.util.FakeDB;

public class AccountRepoImpl implements AccountRepo {

	@Override
	public Account getAccount(int id) {
		return FakeDB.accounts.get(id);
	}

	@Override
	public List<Account> getAllAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		Set<Integer> keys = FakeDB.accounts.keySet();
		keys.forEach(key -> accountList.add(FakeDB.accounts.get(key)));
		
		return accountList;
	}
	
	@Override
	public List<Account> getAllCAccounts() {
		List<Account> accountList = new ArrayList<Account>();
		Set<Integer> keys = FakeDB.accounts.keySet();
		keys.forEach(key -> accountList.add(FakeDB.accounts.get(key)));
		
		return accountList;
	}

	@Override
	public Account addAccount(Account a) {
		a.setId(FakeDB.idCount2++);
		
		FakeDB.accounts.put(a.getId(), a);
		
		return a;
	}

	@Override
	public Account updateAccount(Account change) {
		FakeDB.accounts.replace(change.getId(), change);
		return change;
	}

	@Override
	public Account deleteAccount(int id) {
		return FakeDB.accounts.remove(id);
	}

	@Override
	public Account changeType(Account change) {
		return FakeDB.accounts.replace(change.getId(), change);
	}

	@Override
	public Account addCAccount(Account a) {
		a.setId(FakeDB.idCount2++);
		
		FakeDB.accounts.put(a.getId(), a);
		
		return a;
	}

	@Override
	public Account addSAccount(Account a) {
		a.setId(FakeDB.idCount2++);
		
		FakeDB.accounts.put(a.getId(), a);
		
		return a;
	}

}
