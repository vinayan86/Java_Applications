package com.face.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.face.bo.UserAccount;

public class DBUtils {

	public static UserAccount findUser(Connection conn, 
	           String userName, String password) throws SQLException {
	       String sql = "Select a.User_Name, a.Password from User_Account a where a.User_Name = ? and a.password= ?";
	       System.out.println(sql);
	       PreparedStatement pstm = conn.prepareStatement(sql);
	       pstm.setString(1, userName);
	       pstm.setString(2, password);
	       ResultSet rs = pstm.executeQuery();
	       if (rs.next()) {
	         
	           UserAccount user = new UserAccount();
	           user.setUserName(userName);
	           user.setPassword(password);
	           
	           return user;
	       }
	       return null;
	   }
	
	
}
