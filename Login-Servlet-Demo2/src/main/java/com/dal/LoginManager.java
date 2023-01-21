package com.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.User;

public class LoginManager {
	
	Connection con;
	PreparedStatement pstmt;
	User user;
	
	public LoginManager() throws SQLException
	{
		con=DbConnector.openConnection();
		pstmt=con.prepareStatement("select * from credentials where email=? and password=?");
	}
	
	
	public User validateUser(String email,String password) throws SQLException
	{
		pstmt.setString(1, email);
		pstmt.setString(2, password);
		
		ResultSet rset=pstmt.executeQuery();
		
		if(rset.next())
		{
			user=new User(rset.getString(1), rset.getString(2),rset.getString(3), rset.getString(4), rset.getString(5));
			
			System.out.println(user+"In Login manager if block");
			return user;
		}
		else {
			System.out.println(user+"In Login manager else block");
		return null;
		
		}
	}
	
	public void closeSt() throws SQLException
	{
		if(pstmt!=null)
		{
			pstmt.close();
		}
	}

}
