package com.crony.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.crony.exceptions.BusinessException;
import com.crony.model.User_Acc;
import com.crony.service.MainMenuService;
import com.crony.service.impl.MainMenuServiceImpl;

public class MainMenuImpl implements MainMenu {
	private static final Logger log = Logger.getLogger(CronyMain.class);

	MainMenuService mm = new MainMenuServiceImpl();

	@Override
	public void mainMenu(User_Acc u) {
		Scanner sc = new Scanner(System.in);
		log.info("\n\n\n\n\n				 Main Menu");
		log.info("--------------------------------------------------------------------------- \n");
		int ch = 0;
		int ch2 = 0;
		do {
			log.info("\n\n"+u.getCa().toString());
			log.info("\n Please select an option below.");
			log.info("1) Deposit");
			log.info("2) Withdrawl");
			log.info("3) View Balance");
			log.info("4) Log Out");

			// log.info("5) Add a New Checking or Savings Account");
			// log.info("6) View Transaction History");
			// log.info("7) Transfer");

			log.info("Enter your choice(1-4)");
			try {
				ch = Integer.parseInt(sc.next());
				switch (ch) {
				case 1:
//					log.info("Select account to deposit into.");
//					long act = sc.nextLong();
					log.info("Select deposit amount.");
					double amt = sc.nextDouble();
					log.info(" \n\n You are about to deposit $" + amt);
					log.info("Enter 1 to confirm transaction or 2 to go back.");
					log.info("1) Confirm");
					log.info("2) Go Back");
					ch2 = Integer.parseInt(sc.next());
					try {
					if (ch2 == 1) {
						// complete deposit
						
							
						
						u.setCa(mm.depositChecking((float) amt, u.getCa()));
						log.info(" \n\n Deposit Complete! Your new balance is $"+u.getCa().getBalance());

					} else if (ch2 == 2) {
						log.info("Deposit Canceled.");
					} else {
						log.info("Invalid entry. Please try again.");

					}
					}catch (BusinessException e) {
						System.out.println(e);
						System.out.println(e.getMessage());
						log.info("Business Exception");
						
					}
					break;
				case 2:
//					log.info("Select account to withdrawl from.");
//					long act2 = sc.nextLong();
					log.info("Select withdrawl amount.");
					double amt2 = sc.nextDouble();
					log.info(" \n\n You are about to withdawl $" + amt2);
					log.info("Enter 1 to confirm transaction or 2 to go back.");
					log.info("1) Confirm");
					log.info("2) Go Back");
					ch2 = Integer.parseInt(sc.next());
					if (ch2 == 1) {
						try {
							// complete withdrawl
							mm.withdrawlChecking((float) amt2, u.getCa());
							log.info("Withdrawl Complete! Your new Balance is $" + u.getCa().getBalance());
							
						} catch (BusinessException e) {
							log.info(e.getMessage());
							
						}catch (Exception e) {
							log.info("general Exception");
						}
						
					} else if (ch2 == 2) {

						log.info("Withdrawl Canceled. \n\n\n");

					} else {
						log.info("Invalid entry. \n\n\n");

					}
					break;
//				case 3:
//					log.info("Select account that you would like to transfer to.");
//					long to = sc.nextLong();
//					log.info("Select account that you would like to transfer from.");
//					long from = sc.nextLong();
//					log.info("Select amount to transfer.");
//					double amt3 = sc.nextDouble();
//					log.info("You are about to transfer $" + amt3 + " from " + from + " to " + to);
//					log.info("Enter 1 to confirm transaction or 2 to go back.");
//					log.info("1) Confirm");
//					log.info("2) Go Back");
//					switch (ch2) {
//					case 1:
//						break;
//					case 2:
//						break;
//					}
//					break;
				case 3:
//				log.info("Select Account");
//					long acc = sc.nextLong();
					try {
					log.info("Printing Balance \n");
					log.info("Your current balance is $"+mm.getBalance(u.getCa()));
					}catch(BusinessException e) {
						System.out.println(e);
						
					}
					break;
//				case 5:
//					do {
//						log.info("Select New Account Type");
//
//						log.info("1) Checking ");
//						log.info("2) Savings ");
//						log.info("3) Go Back ");
//						switch (ch2) {
//						case 1:
//							// create new checking
//							break;
//						case 2:
//							// create new savings
//							break;
//						case 3:
//							break;
//						default:
//							log.info("Please enter a valid option");
//						}
//					} while (ch2 != 3);
//					break;
//				case 6:
//					log.info("Printing Transaction History");
//					break;
				case 4:
					log.info("Thank you for banking with us!");
					break;

				}
			} catch (Exception e) {
				log.info("Whoopsie Daisy");
				System.out.println(e);
				System.out.println(e.getMessage());
			}
		} while (ch != 4);

	}

}
