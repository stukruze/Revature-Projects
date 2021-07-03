package com.stuartkruze.models;

public class Account {

	private int id;
	private int clientId;
	private double balance;

	public Account() {
		super();
	}

	public Account(int id, int clientId, double balance) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.balance = balance;
	}

	public Account(int clientId, double balance) {
		super();
		this.clientId = clientId;
		this.balance = balance;
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
		return "Account [id=" + id + ", clientId=" + clientId + ", balance=" + balance + "]";
	}

}
