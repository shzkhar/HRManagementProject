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

	public int addHr(String hrname, String hremail, String hrpassword, String hrmobno) {
		
		Connection con = DbConnection.getConnection();
		int rowaffected=0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into Hr values(?,?,?,?)");
			
			ps.setString(1, hrname);
			ps.setString(2,hremail);
			ps.setString(3, hrpassword);
			ps.setString(4, hrmobno);
			
			 rowaffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowaffected;
	}

	
}
