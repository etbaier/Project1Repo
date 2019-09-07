package com.crony.service;

import java.util.List;

import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;
import com.crony.model.Transaction;

public interface MainMenuService {
//	log.info("Please select an option below.");
//	log.info("1) Deposit");
//	log.info("2) Waithdrawl");
//	log.info("3) Transfer");
//	log.info("4) View Balance");
//	log.info("5) Add a New Checking or Savings Account");
//	log.info("6) View Transaction History");
//	log.info("7) Log Out");
//	log.info("Enter your choice(1-7)");
	
	public Checking_Account withdrawlChecking(float amt, Checking_Account checking_Account) throws BusinessException;
	public float getBalance(Checking_Account ca) throws BusinessException;
	//public List<Transaction> getTransactionHistory();
	Checking_Account depositChecking(float amt, Checking_Account c) throws BusinessException;

}
