package com.shubham.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	private static Connection con=null;
	public static Connection getConnection(){
		if(con!=null) {
			return con;
		}
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb", "root", "singh");
		}catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
		catch( SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

}
