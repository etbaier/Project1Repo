package com.crony.service.impl.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import com.crony.service.CronyLogInService;
import com.crony.service.impl.CronyLogInServiceImpl;



public class CronyTest {
	private static CronyLogInService cService;
	
	
	@BeforeAll
	public static void instantiateService(){
		System.out.println("First");
		cService= new CronyLogInServiceImpl();
	}

	
	@Test
	public void testLogIn() {
		//fail("Not yet implemented");
		long x= 1000000000000009l;
		Checking_Account ca= new Checking_Account(100001, 0, x, 200, null);
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
		try {
			assertEquals(u,cService.logIn("user1", "user1"));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
			
		}
	}

	@Test 
	public void testRegister() {
		long x= 1000000000000014l;
		Checking_Account ca= new Checking_Account(100016, 0, x, 0, null);
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
		System.out.println("Test Login");	try {
			assertEquals(u,cService.registerUser("user3", "user3", "Ethan", "Baier", 9705892688l, "01/09/1994", 523916094l, "etbaier9@gmail.com", "18219 B Rd", 1994));
		} catch (BusinessException e) {
			System.out.println(e.getMessage());
	
		}
	}
/*	
	@Test
	public void testNegative() {
		System.out.println("Testing negative");
		assertFalse(service.isPrime(-5));
	}
	
	@Test
	public void testBoundaries() {
		System.out.println("Boundaries, boi");
		assertFalse(service.isPrime(Integer.MAX_VALUE));
		assertFalse(service.isPrime(Integer.MIN_VALUE));
	}
	@Test
	public void TestSS() {
		System.out.println("SS Tested");
		assertTrue(service.isValidSS("123-45-6789"));
		assertFalse(service.isValidSS("123"));
	}
	*/
	@AfterAll
	public static void afterAll() {
		System.out.println("Last");
	}
	
}
