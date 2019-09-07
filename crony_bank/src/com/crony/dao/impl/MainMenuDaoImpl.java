package com.crony.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.crony.dao.MainMenuDao;
import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;
import com.crony.model.User;
import com.crony.model.User_Acc;
import com.dbutil.OracleConnection;

public class MainMenuDaoImpl implements MainMenuDao {

	@Override
	public Checking_Account withdrawlChecking(float amt, Checking_Account c) throws BusinessException {
		
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "{call checkingwithdrawl(?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setFloat(1, amt);
			callableStatement.setLong(2, c.getAccount_number());

			callableStatement.executeUpdate();
			c.setBalance(getBalance(c));
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Well that's embarassing... Internal Error \n\n\n");
		}
		return c;

	}

	@Override
	public Checking_Account depositChecking(float amt, Checking_Account c) throws BusinessException {
		User_Acc ua = null;
		User u = null;

		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "{call checkingdeposit(?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setFloat(1, amt);
			callableStatement.setLong(2, c.getAccount_number());
//			System.out.println("amt = "+amt);
//			System.out.println("acc number "+c.getAccount_number());
			callableStatement.execute();
//			connection.commit();
//			System.out.println("executed");
			c.setBalance(getBalance(c));
			
		} catch (ClassNotFoundException | SQLException e) {
			
			throw new BusinessException("Well that's embarassing... Internal Error\n\n\n");
		}
		return c;

	}

	@Override
	public float getBalance(Checking_Account c) throws BusinessException {

		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "select balance from checking_acc where acc_number=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setLong(1, c.getAccount_number());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()== true) {
				
				float b=resultSet.getFloat("balance");
				return b;
			} else {
				throw new BusinessException("No account found... \n\n\n");
			}
			
		} catch (ClassNotFoundException e) {
			
			throw new BusinessException("Internal Error....SYSADMIn is working on that");
		}
		catch( SQLException e) {
			throw new BusinessException(e.getMessage());
		}
	}

}
