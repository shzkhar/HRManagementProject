package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbConnection.DbConnection;

public class AdminDao {

	

	public boolean authenticate(String email, String password) {
		Connection con = DbConnection.getConnection();
		boolean ret =true;
		try {
			PreparedStatement ps = con.prepareCall("select * from Admin where AdminEmail=? & AdminPass=?");
			
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				rs.getString("AdminEmail");
				rs.getString("AdminPass");
			}
			if(rs==null)
			{
				ret=false;
				return ret;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	
}
