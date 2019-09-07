package com.crony.dao;

import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;

public interface MainMenuDao {

	public float getBalance(Checking_Account c) throws BusinessException;
	Checking_Account withdrawlChecking(float amt, Checking_Account c) throws BusinessException;
	Checking_Account depositChecking(float amt, Checking_Account c) throws BusinessException;
}
