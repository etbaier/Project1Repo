package com.crony.dao;

import java.util.Date;

import com.crony.exceptions.BusinessException;
import com.crony.model.User_Acc;

public interface LogInDao {

	public User_Acc logIn(String username, String password) throws BusinessException;
	public User_Acc register(String username, String password, String fname, String lname, long phone, String dob, long ssn, String email,
			String address, int pin) throws BusinessException;

}
