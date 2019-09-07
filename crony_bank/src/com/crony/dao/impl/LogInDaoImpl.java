package com.crony.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.crony.dao.LogInDao;
import com.crony.exceptions.BusinessException;
import com.crony.model.Checking_Account;
import com.crony.model.User;
import com.crony.model.User_Acc;
import com.crony.service.MD5Demo;
import com.dbutil.OracleConnection;

public class LogInDaoImpl implements LogInDao {

	@Override
	public User_Acc logIn(String username, String password) throws BusinessException {
		User_Acc ua = new User_Acc(username, password, 0, 0, null, null);
		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "select u.username, u.password, u.userid, u.pin, c.balance, c.acc_number from user_acc u JOIN checking_acc c on u.userid = c.user1"
					+ " where u.username=? and u.password=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next() == false) {
				throw new BusinessException("I couldn't find an account with that username and password. \n\n\n");
			} else {

				ua.setUsername(username);
				ua.setPassword(password);
				ua.setPin(resultSet.getInt("pin"));
				ua.setUid(resultSet.getLong("userid"));
				Checking_Account ca = new Checking_Account(resultSet.getLong("userid"), 0,
						resultSet.getLong("acc_number"), resultSet.getFloat("balance"), ua);
				ua.setCa(ca);

			}
//			while (resultSet.next()) {
//				for (int i = 1; i < 5; i++) {
//					System.out.print(resultSet.getObject(i));
//				}
//				System.out.println();
//			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal Error....SYSADMIn is working on that");
		}

		return ua;
	}

	@Override
	public User_Acc register(String username, String password, String fname, String lname, long phone, String dob,
			long ssn, String email, String address, int pin) throws BusinessException {

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sdf.setLenient(false);
		User u = new User(username, fname, lname, null, ssn, address, email, new MD5Demo().md5(password)); // hashes password
		User_Acc ua = new User_Acc(username, password, 0, pin, u, null);

		try {

			u.setDob(sdf.parse(dob));
		} catch (ParseException e1) {
			throw new BusinessException("Invalid Date");
		}

		try (Connection connection = OracleConnection.getConnection()) {
			String sql = "{call newuser(?,?,?,?,?,?,?,?,?,?,?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sql);
			callableStatement.setString(1, username);
			callableStatement.setString(2, fname);
			callableStatement.setString(3, lname);
			callableStatement.setDate(4, new java.sql.Date(u.getDob().getTime()));
			callableStatement.setLong(5, ssn);
			callableStatement.setString(6, email);
			callableStatement.setString(7, address);
			callableStatement.setInt(8, pin);
			callableStatement.setString(9, password);
			callableStatement.setString(11, null);
			callableStatement.registerOutParameter(10, java.sql.Types.NUMERIC);
			callableStatement.registerOutParameter(12, java.sql.Types.NUMERIC);

			callableStatement.execute();
			ua.setUid(callableStatement.getLong(10));
			Checking_Account c = new Checking_Account(ua.getUid(), 0, callableStatement.getLong(12), 0, ua);
			//c.setAccount_number(callableStatement.getLong(12));
			ua.setCa(c);
		} catch (ClassNotFoundException e) {
			
			throw new BusinessException("Well that's embarassing... Internal Error\n\n");
		} catch (SQLException e) {
			
		
			throw new BusinessException("That username is alread taken! Try again. \n\n\n");
		}
		return ua;

	}

}
