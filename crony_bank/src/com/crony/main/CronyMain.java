package com.crony.main;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crony.exceptions.BusinessException;
import com.crony.service.impl.CronyLogInServiceImpl;

public class CronyMain {

	private static final Logger log = Logger.getLogger(CronyMain.class);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int ch = 0;
		log.info("Welcome to Crony Bank! You need to log in or create an account before we can take all your money.");
		log.info(
				"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		do {
			log.info("1) Log in");
			log.info("2) Register");
			log.info("3) EXIT");
			log.info("Enter choice (1-3)");
			try {
				ch = Integer.parseInt(sc.next());
				MainMenu mm = new MainMenuImpl();
				CronyLogInServiceImpl li = new CronyLogInServiceImpl();
				switch (ch) {

				case 1:
					log.info("Enter username");
					String un = sc.next();

					log.info("Enter Password");
					String pw = sc.next();
					// call service method

					try {

						mm.mainMenu(li.logIn(pw, un));
					} catch (BusinessException e) {
						log.info(e.getMessage());
						
					}

					break;
				case 2:
					try {
						log.info(
								"We are excited to work with you! But we need to know a little bit about you before we get started.");
						log.info(
								"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ \n");
						log.info("Enter your first name");
						String fname = sc.next();
						log.info("Enter your last name");
						String lname = sc.next();
						log.info("Enter phone number (no dashes please. Correct format: 1234567890) ");
						long phone = sc.nextLong();
						log.info("Enter Date of Birth (MM/dd/yyyy)");
						String dob = sc.next();
						log.info("Enter email");
						String email = sc.next();
						log.info("Enter Address");
						String address = sc.next();
						log.info("Enter Social Security Number (no dashes please. Correct format: 123456789)");
						long ssn = sc.nextLong();
						log.info("Create a username");
						String username = sc.next();
						log.info("Create password");
						String password = sc.next();
						log.info("Create a 4 digit PIN");
						int pin = sc.nextInt();
						// call service method

						li.registerUser(username, password, fname, lname, phone, dob, ssn, email, address, pin);
						log.info("Account Registered! We set up a checking account for you to get you started. \n\n\n");
						mm.mainMenu(li.logIn(password, username));
					}catch (InputMismatchException e) {
						log.info("Please enter fields in the proper format! \n\n\n\n\n");
					} catch (BusinessException e) {
						
						log.info(e.getMessage()+"\n\n\n");

					} catch (Exception e) {
						System.out.println("General Exception");
						System.out.println(e.getMessage());
						System.out.println(e);
					}

					break;

				case 3:
					log.info("\n\n Bye for now!");
					break;
				default:
					log.info("Invalid entry... Please try again.");
				}

			} catch (NumberFormatException e) {
				log.info("Please enter 1, 2, or 3.");
			}
		} while (ch != 3);

	}

}
