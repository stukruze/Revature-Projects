package com.stuartkruze.models;

public class Account {

	private int id;
	private int clientId;
	private double balance;
	private String type;
	private double withdraw;
	private double deposit;
	private boolean fail;
	
	public Account() {
		super();
	}

	public Account(int id, int clientId, double balance, String type) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.balance = balance;
		this.type = type;
	}

	public Account(int clientId, double balance, String type) {
		super();
		this.clientId = clientId;
		this.balance = balance;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", clientId=" + clientId + ", balance=" + balance + ", type=" + type + "]";
	}

	public double getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(double withdraw) {
		this.withdraw = withdraw;
	}

	public double getDeposit() {
		return deposit;
	}

	public void setDeposit(double deposit) {
		this.deposit = deposit;
	}

	public boolean isFail() {
		return fail;
	}

	public void setFail(boolean fail) {
		this.fail = fail;
	}



}
