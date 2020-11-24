package com.shubham.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shubham.beans.LoginBean;
import com.shubham.connection.ConnectionProvider;

public class LoginDAO {
	private Connection con;
	public LoginDAO(){
		
	}
	public int addUser(LoginBean obj) {
		int result=0;
		try {
		con=ConnectionProvider.getConnection();
		PreparedStatement ps= con.prepareStatement("insert into login (username,password) value (?,?)");
		ps.setString(1, obj.getUserName());
		ps.setString(2, obj.getPassword());
		result=ps.executeUpdate();
		System.out.println("user added successfully");
		}catch(SQLException sql) {
			if((sql.getMessage()).contains("Duplicate entry")) {
				result=0;
				System.out.println("Duplicate entry");
			}else {
				sql.printStackTrace();
			}
			
		}
		return result;
	}
	public int isvalidLogin(LoginBean obj) {
		int result=0;
		try
		{
		con=ConnectionProvider.getConnection();
		String sql="select * from login where username=?";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, obj.getUserName());
		ResultSet rs= ps.executeQuery();
		if(rs.next()) {
			if((obj.getPassword()).equals(rs.getString(3))) {
				result=1;
				System.out.println("Logged in!");
			}else {
				result=2;
				System.out.println("password mismatched!");
			}
		}else {
			System.out.println("Logged failed user does not exists!");
		}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
