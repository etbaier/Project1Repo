package com.crony.model;

public class Checking_Account {

	private long user1;
	private long user2;
	private long account_number;
	private float balance;
	private User_Acc user;

	public Checking_Account(long l, long user2, long account_number, float balance, User_Acc user) {
		super();
		this.user1 = l;
		this.user2 = user2;
		this.account_number = account_number;
		this.balance = balance;
	}

	public long getUser1() {
		return user1;
	}

	public void setUser1(int user1) {
		this.user1 = user1;
	}

	public long getUser2() {
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

	@Override
	public String toString() {
		return "Checking_Account " + account_number
				+ ": balance = $" + balance ;
	}

	public User_Acc getUser() {
		return user;
	}

	public void setUser(User_Acc user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (account_number ^ (account_number >>> 32));
		result = prime * result + Float.floatToIntBits(balance);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Checking_Account other = (Checking_Account) obj;
		if (account_number != other.account_number)
			return false;
		if (Float.floatToIntBits(balance) != Float.floatToIntBits(other.balance))
			return false;
		return true;
	}

	
}
