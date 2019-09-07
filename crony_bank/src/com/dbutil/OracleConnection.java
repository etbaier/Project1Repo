package com.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	private static Connection connection;
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		//step1
		Class.forName("oracle.jdbc.OracleDriver");
//		System.out.println("Driver Loaded");
		//step 2
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String user = "Ethan";
		String pw = "Ethan";
		return connection= DriverManager.getConnection(url, user, pw);
	

	}
}
// Single TON Java Class
