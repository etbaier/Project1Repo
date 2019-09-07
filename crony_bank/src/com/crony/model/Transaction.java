package com.crony.model;

public class Transaction {
	
	private int id;
	private String date;
	private double amount;
	private long acc_from;
	private long acc_to;
	public Transaction(int id, String date, double amount, long acc_from, long acc_to) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.acc_from = acc_from;
		this.acc_to = acc_to;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getAcc_from() {
		return acc_from;
	}
	public void setAcc_from(long acc_from) {
		this.acc_from = acc_from;
	}
	public long getAcc_to() {
		return acc_to;
	}
	public void setAcc_to(long acc_to) {
		this.acc_to = acc_to;
	}

}
