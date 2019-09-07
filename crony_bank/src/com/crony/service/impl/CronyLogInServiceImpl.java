package com.crony.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.crony.dao.LogInDao;
import com.crony.dao.impl.LogInDaoImpl;
import com.crony.exceptions.BusinessException;
import com.crony.model.User_Acc;
import com.crony.service.CronyLogInService;

public class CronyLogInServiceImpl implements CronyLogInService {

	private LogInDao loginDao;

	@Override
	public User_Acc logIn(String password, String username) throws BusinessException {
		User_Acc ua =new User_Acc();
		if (password != null && username != null) {
			try {
				ua = getLogInDao().logIn(username, password);
			} catch (NullPointerException e) {
				throw new BusinessException("I couldn't find an account with that username and password. \n\n\n");
			}
		} else {
			throw new BusinessException("Please Enter a valid username and password \n\n\n");
		}
		return ua;
	}

	@Override
	public User_Acc registerUser(String username, String password, String fname, String lname, long phone, String dob,
			long ssn, String email, String address, int pin) throws BusinessException {
		User_Acc ua = null;
		if (fname.matches("[a-zA-Z]{0,20}") | lname.matches("[a-zA-Z]{0,20}") ) {
		 
		} else {
			throw new BusinessException("Invalid name");
		}
		if((phone + ""). matches("[0-9]{10}")) {
			
		} else {
			throw new BusinessException("Invalid phone number");
		} 
		if(dob.matches("[0-9]{2}/[0-9]{2}/[1-2]{1}[0-9]{3}")) {
			
		}else {
			throw new BusinessException("Invalid date");
		}
		if((ssn + "").matches("[0-9]{9}")) {
			
		} else {
			throw new BusinessException("Invalid ssn");
		}
		if(email.matches("[^(.)+@(.+)$]") ) {
			
		} else {
			throw new BusinessException("Invalid email");
		}
		if( address!= null) {
			
		}else {
			throw new BusinessException("Invalid address");
			
		}
		if((pin + "").matches("[0-9]{4}")) {
			
		}else {
			throw new BusinessException("Invalid pin");
		}
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			sdf.setLenient(false);
			try {
				sdf.parse(dob);
				ua = getLogInDao().register(username, password, fname, lname, phone, dob, ssn, email, address, pin);
			} catch (ParseException e) {
				throw new BusinessException("Invalid date entered.");
			} catch (BusinessException e) {
				throw new BusinessException(e.getMessage());
			}
		 
		return ua;
	}

	public LogInDao getLogInDao() {
		if (loginDao == null) {
			loginDao = new LogInDaoImpl();
		}
		return loginDao;
	}
}
