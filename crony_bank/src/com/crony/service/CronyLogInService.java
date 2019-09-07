package com.crony.service;

import java.util.Date;

import com.crony.exceptions.BusinessException;
import com.crony.model.User_Acc;

public interface CronyLogInService {

	public User_Acc logIn(String password, String username) throws BusinessException;
	public User_Acc registerUser(String username, String password, String fname, String lname, long phone, String dob, long ssn, String email,
			String address, int pin) throws BusinessException;
}
