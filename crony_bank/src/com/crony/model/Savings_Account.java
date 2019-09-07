package com.crony.model;

public class Savings_Account {
	
	private int user1;
	private int user2;
	private long account_number;
	private float balance;
	private double interest;
	
	public Savings_Account(int user1, int user2, long account_number, float balance, double interest) {
		super();
		this.user1 = user1;
		this.user2 = user2;
		this.account_number = account_number;
		this.balance = balance;
		this.interest = interest;
	}
	public int getUser1() {
		return user1;
	}
	public void setUser1(int user1) {
		this.user1 = user1;
	}
	public int getUser2() {
		return user2;
	}
	public void setUser2(int user2) {
		this.user2 = user2;
	}
	public long getAccount_number() {
		return account_number;
	}
	public void setAccount_number(long account_number) {
		this.account_number = account_number;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}

}
