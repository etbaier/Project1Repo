package com.crony.service.impl.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;
import com.crony.model.User;
import com.crony.model.User_Acc;
import com.crony.service.MainMenuService;
import com.crony.service.impl.MainMenuServiceImpl;

public class MaiinMenuTest {
	private static MainMenuService mService;
	@BeforeAll
	public static void instantiateService(){
	
		mService= new MainMenuServiceImpl();
	}
	/*
	public Checking_Account withdrawlChecking(float amt, Checking_Account checking_Account) throws BusinessException;
	public float getBalance(Checking_Account ca) throws BusinessException;
	//public List<Transaction> getTransactionHistory();
	Checking_Account depositChecking(float amt, Checking_Account c) throws BusinessException;
*/
	
	@Test
	public void testWithdrawl() {
		//fail("Not yet implemented");
		long x= 1000000000000009l;
		Checking_Account ca= new Checking_Account(100001, 0, x, 200, null);
		Checking_Account ca2= new Checking_Account(100001, 0, x, 150, null);
		User user= new User("user1", "Ethan", "Baier", null, 123456789, "e", "e", "user1");
		String dob= "01/09/1994";
		SimpleDateFormat sfd= new SimpleDateFormat("MM/dd/yyyy");
		sfd.setLenient(false);
		try {
			user.setDob(sfd.parse(dob));
		} catch (ParseException e) {
	
			e.printStackTrace();
		}
	
		User_Acc u= new User_Acc("user1", "user1", 100001, 1994, null, ca);
		ca.setUser(u);
		ca2.setUser(u);

		try {
			assertEquals(ca2.getBalance(),mService.withdrawlChecking(50, ca).getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			
		}
	}

	@Test 
	public void testDeposit() {
		long x= 1000000000000014l;
		Checking_Account ca= new Checking_Account(100016, 0, x, 200, null);
		Checking_Account ca2= new Checking_Account(100016, 0, x, 250, null);
		User user= new User("user3", "Ethan", "Baier", null, 123456789, "18219 B Rd", "etbaier9@gmail.com", "user3");
		String dob= "01/09/1994";
		SimpleDateFormat sfd= new SimpleDateFormat("MM/dd/yyyy");
		sfd.setLenient(false);
		try {
			user.setDob(sfd.parse(dob));
		} catch (ParseException e) {
		
			e.printStackTrace();
		}
	
		User_Acc u= new User_Acc("user3", "user3", 100016, 1994, user, ca);
		
		ca.setUser(u);
		ca2.setUser(u);
		try {
			assertEquals(ca2.getBalance(),mService.depositChecking(50, ca).getBalance());
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
	
		}
	}
	
	@Test
	public void testGetBalance() {
		//fail("Not yet implemented");
		long x= 1000000000000009l;
		Checking_Account ca= new Checking_Account(100001, 0, x, 200, null);
		Checking_Account ca2= new Checking_Account(100001, 0, x, 150, null);
		User user= new User("user1", "Ethan", "Baier", null, 123456789, "e", "e", "user1");
		String dob= "01/09/1994";
		SimpleDateFormat sfd= new SimpleDateFormat("MM/dd/yyyy");
		sfd.setLenient(false);
		try {
			user.setDob(sfd.parse(dob));
		} catch (ParseException e) {

			e.printStackTrace();
		}
	
		User_Acc u= new User_Acc("user1", "user1", 100001, 1994, null, ca);
		ca.setUser(u);
		ca2.setUser(u);
		try {
			
			assertEquals(ca.getBalance(),mService.getBalance(ca));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			
		}
	}
	@AfterAll
	public static void afterAll() {
	
	}
}
