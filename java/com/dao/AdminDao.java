package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.AdminBean;
import com.bean.HrBean;
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
		
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return adminBean;
	}

	public String checkDuplicate(String hremail, String hrmobno)
	{
		String check = null;
		Connection con = DbConnection.getConnection();
	
		try {
			PreparedStatement ps1 = con.prepareStatement("select * from Hr where HrEmail=? ");
			ps1.setString(1,hremail);
			
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.isBeforeFirst())
			{
				check = "email";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement ps1 = con.prepareStatement("select * from Hr where HrMobno=? ");
			ps1.setString(1,hrmobno);
			
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.isBeforeFirst())
			{
				check = "mobno";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return check;
	}
	
	public String addHr(String hrname, String hremail, String hrpassword, String hrmobno) {
		String check = checkDuplicate(hremail,hrmobno);
		int rowaffected = 0;
		Connection con = DbConnection.getConnection();
		
		if(check==null)
		{
			try {
				PreparedStatement ps = con.prepareStatement("insert into Hr values(?,?,?,?)");
				
				ps.setString(1, hrname);
				ps.setString(2,hremail);
				ps.setString(3, hrpassword);
				ps.setString(4, hrmobno);
				
				 rowaffected = ps.executeUpdate();
				check=String.valueOf(rowaffected);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}	
		else if(check.equals("email"))
		{
			check="email";
		}
		else if(check.equals("mobno"))
		{
			check="mobno";
		}
		
	return check;
	}

	public ArrayList<HrBean> getAllHr()
	{
		ArrayList<HrBean> hrBeanAL = new ArrayList<HrBean>();
		
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Hr");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				HrBean hrBean = new HrBean();
				hrBean.setId(rs.getInt("HrId"));
				hrBean.setHrname(rs.getString("HrName"));
				hrBean.setHremail(rs.getString("HrEmail"));
				hrBean.setHrpassword(rs.getString("HrPass"));
				hrBean.setHrmobno(rs.getString("HrMobno"));
				
				hrBeanAL.add(hrBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hrBeanAL;
	}

	public void deleteHr(String id) {
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from Hr where HrId=?");
			
			ps.setInt(1, Integer.valueOf(id));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}



	public HrBean getHrDetails(String hrid) {
		HrBean hrBean = new HrBean();
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Hr where HrId=?");
			ps.setInt(1, Integer.valueOf(hrid));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				hrBean.setId(rs.getInt("HrId"));
				hrBean.setHrname(rs.getString("HrName"));
				hrBean.setHremail(rs.getString("HrEmail"));;
				hrBean.setHrpassword(rs.getString("HrPass"));
				hrBean.setHrmobno(rs.getString("HrMobno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return hrBean;
	}

	public void updateHr(HrBean hrBean) {
		 Connection con = DbConnection.getConnection();
		 
		 try {
			PreparedStatement ps = con.prepareStatement("update Hr set HrName=?,HrEmail=?,HrPass=?,HrMobno=? where HrId=?");
			
			ps.setString(1, (hrBean.getHrname()));
			ps.setString(2, (hrBean.getHremail()));
			ps.setString(3, (hrBean.getHrpassword()));
			ps.setString(4, (hrBean.getHrpassword()));
			ps.setInt(5, (hrBean.getId()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public HrBean getHrInfo(String hrid) {
		HrBean hrBean = null;
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Hr where HrId=?");
			
			ps.setInt(1, Integer.valueOf(hrid));
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				hrBean = new HrBean();
				hrBean.setId(rs.getInt("HrId"));
				hrBean.setHrname(rs.getString("HrName"));
				hrBean.setHremail(rs.getString("HrEmail"));
				hrBean.setHrpassword(rs.getString("HrPass"));
				hrBean.setHrmobno(rs.getString("HrMobno"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hrBean;
	}

	public ArrayList<HrBean> search(String hrname) {
		
		HrBean hrBean = null;
		ArrayList<HrBean> hrBeansAL = new ArrayList<HrBean>();
		try {
			Connection con = DbConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from Hr where HrName like ?");
			
			ps.setString(1, hrname+"%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				hrBean = new HrBean();
				hrBean.setId(rs.getInt("HrId"));
				hrBean.setHrname(rs.getString("HrName"));
				hrBean.setHremail(rs.getString("HrEmail"));
				hrBean.setHrpassword(rs.getString("HrPass"));
				hrBean.setHrmobno(rs.getString("HrMobno"));
				
				hrBeansAL.add(hrBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hrBeansAL;
		
	}
}
