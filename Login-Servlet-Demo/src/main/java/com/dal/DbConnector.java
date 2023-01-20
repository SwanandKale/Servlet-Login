package com.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
	public static Connection con;
	
	public static Connection openConnection() throws SQLException
	{
		System.out.println("Database connected");
		con= DriverManager.getConnection("jdbc:mysql://localhost:3306/logininfo","root","swanand@123");
		return con;
	}
	
	public static void closeConnection() throws SQLException
	{
		con.close();
	}
	
	

}
