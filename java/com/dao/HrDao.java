package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.HrBean;
import com.dbConnection.DbConnection;

public class HrDao {

	public HrBean authenticate(String hremail, String hrpassword) {
		HrBean hrBean = null;
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Hr where HrEmail=? and HrPass=?");
			
			ps.setString(1, hremail);
			ps.setString(2, hrpassword);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.isBeforeFirst())
			{
				hrBean = new HrBean();
				hrBean.setHremail(rs.getString("HrEmail"));
				hrBean.setHrpassword(rs.getString("HrPass"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hrBean;
	}

	public int addResource(String name, String email, String mobno, String gender, String experience, String url,String qualification)
	{
		int rowafffected=0;
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into Resource values(Name=?, Email=?,Gender=?, Experience=?,Resumeurl=?,Qualification=?)");
		    
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobno);
			ps.setString(4, gender);
			ps.setString(5, experience);
			ps.setString(6, url);
			ps.setString(7, qualification);
			
			rowafffected = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowafffected;
		
	}

	

	
}
