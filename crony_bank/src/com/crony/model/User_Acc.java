package com.crony.model;

public class User_Acc {

	private String username;
	private String password;
	private long uid;
	private int pin;
	private User user;
	private Checking_Account ca;
	
	public User_Acc() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
		this.uid = uid;
	}
	public User_Acc(String username, String password, long uid, int pin, User user, Checking_Account ca) {
		super();
		this.username = username;
		this.password = password;
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "User_Acc [username=" + username + ", password=" + password + ", uid=" + uid + "]";
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Checking_Account getCa() {
		return ca;
	}
	public void setCa(Checking_Account ca) {
		this.ca = ca;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (uid ^ (uid >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User_Acc other = (User_Acc) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (uid != other.uid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	
	
}
