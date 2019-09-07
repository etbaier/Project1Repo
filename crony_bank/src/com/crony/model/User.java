package com.crony.model;

import java.util.Date;

public class User {
	
	private String username;
	private String first_name;
	private String last_name;
	private Date dob;
	private transient long ssn;
	private String address;
	private String email;
	private String password;
	
	public User() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public long getSsn() {
		return ssn;
	}
	public void setSsn(long ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, String first_name, String last_name, Date dob, long ssn, String address,
			String email, String password) {
		super();
		this.username = username;
		this.first_name = first_name;
		this.last_name = last_name;
		this.dob = dob;
		this.ssn = ssn;
		this.address = address;
		this.email = email;
		this.password = password;
	}
	

}
