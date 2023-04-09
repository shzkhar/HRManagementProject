package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.AdminBean;
import com.dbConnection.DbConnection;

public class AdminDao {

	

	public AdminBean authenticate(String email, String password) {
		Connection con = DbConnection.getConnection();
		AdminBean adminBean=null;
		try {
			PreparedStatement ps = con.prepareCall("select * from Admin where AdminEmail=? and AdminPass=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				adminBean = new AdminBean();
				adminBean.setEmail(rs.getString("AdminEmail"));
				adminBean.setPassword(rs.getString("AdminPass"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return adminBean;
	}

	
}
