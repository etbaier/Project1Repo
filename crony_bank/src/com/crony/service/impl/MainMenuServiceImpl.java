package com.crony.service.impl;

import com.crony.dao.MainMenuDao;
import com.crony.dao.impl.MainMenuDaoImpl;
import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;
import com.crony.service.MainMenuService;

public class MainMenuServiceImpl implements MainMenuService {

	private MainMenuDao mainMenuDao;

	@Override
	public Checking_Account depositChecking(float amt, Checking_Account c) throws BusinessException {
	
		 if (amt <= 0) {
			 throw new BusinessException("Amount must be greater than 0.");
			
		} else {
			try {
				
				c = getMainMenuDao().depositChecking(amt,c);
				
			} catch (Exception e) {
				
				throw new BusinessException(e.getMessage());
			}
			
		} 
		
		return c;
	}

	@Override
	public Checking_Account withdrawlChecking(float amt, Checking_Account c) throws BusinessException {
		
		if(amt > c.getBalance() ) {
			throw new BusinessException("You don't have enough money in your account to complete this withdrawl.");
		}else if (amt <= 0) {
			throw new BusinessException("Amount must be greater than 0.");
			
		} else {
			try {
				c = getMainMenuDao().withdrawlChecking(amt, c);
				
			} catch (BusinessException e) {
				throw new BusinessException(e.getMessage());
			}catch (Exception e) {
				throw new BusinessException(e.getMessage());
			}
		}
		return c;
	}

	@Override
	public float getBalance(Checking_Account ca) throws BusinessException {
try {
	

		return getMainMenuDao().getBalance(ca);
} catch( BusinessException e) {
	throw new BusinessException(e.getMessage());
}
	}

	public MainMenuDao getMainMenuDao() {
		if (mainMenuDao == null) {
			mainMenuDao = new MainMenuDaoImpl();
		}
		return mainMenuDao;
	}

}
