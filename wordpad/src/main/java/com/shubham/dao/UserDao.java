package com.shubham.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.shubham.beans.*;
import com.shubham.connection.ConnectionProvider;
public class UserDao {
	private Connection con;
	public void addUser(UserBean user) {
		try {
			con=ConnectionProvider.getConnection();
			PreparedStatement ps= con.prepareStatement("insert into users (userid,firstName,lastName) value(?,?,?)");
			ps.setInt(1, user.getId());
			ps.setString(2, user.getFirstName());
			ps.setString(3, user.getLastName());
			//ps.close();
			ps.executeUpdate();
			//con.close();
			System.out.println("User added successfully");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public void deleteUser(UserBean obj) {
		try {
			con=ConnectionProvider.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from users where userid=?");
			ps.setInt(1, obj.getId());
			int result=ps.executeUpdate();
			if(result==1) {
				System.out.println("User deleted");
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void updateUser(UserBean obj) {
		try
		{
		con= ConnectionProvider.getConnection();
		PreparedStatement ps=con.prepareStatement("update users set firstName=?, lastName=? where userid=?");
		ps.setString(1, obj.getFirstName());
		ps.setString(2, obj.getLastName());
		ps.setInt(3, obj.getId());
		int result=ps.executeUpdate();
		if(result==1) {
			System.out.println("User updated successfully");
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public UserBean getUserById(UserBean obj) {
		UserBean ub=new UserBean();
		try {
			con=ConnectionProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from users where userid=?");
			ps.setInt(1, obj.getId());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ub.setId(rs.getInt(1));
				ub.setFirstName(rs.getString(2));
				ub.setLastName(rs.getString(3));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return ub;
	}
		public List<UserBean> getUsers() {
		List<UserBean> list=new ArrayList<UserBean>();
		try {
			UserBean obj;
			String sql="select * from users";
			con=ConnectionProvider.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next()) {
				obj=new UserBean();
				obj.setId(rs.getInt(1));
				obj.setFirstName(rs.getString(2));
				obj.setLastName(rs.getString(3));
				list.add(obj);
			}
			//rs.close();
			//ps.close();
			//con.close();
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return list;
	}

}
