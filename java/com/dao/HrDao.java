package com.dao;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.HrBean;
import com.bean.ResourceBean;
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
			
			if(rs.next())
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
		int ra = 0;
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into Resource values(?,?,?,?,?,?,?)");
		    
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, mobno);
			ps.setString(4, gender);
			ps.setString(5, experience);
			ps.setString(6, url);
			ps.setString(7, qualification);
			
			ra = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ra;
		
	}

	public ArrayList<ResourceBean> getAllResources() {
		
		ArrayList<ResourceBean> resourceBeanAL = new ArrayList<ResourceBean>();
		ResourceBean resourceBean = null;
		Connection con = DbConnection.getConnection();
		
		try {
			PreparedStatement ps = con.prepareStatement("select * from Resource");
		    
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				resourceBean = new ResourceBean();
				resourceBean.setId(rs.getInt("Id"));
				resourceBean.setName(rs.getString("Name"));
				resourceBean.setEmail(rs.getString("Email"));
				resourceBean.setMobno(rs.getString("Mobno"));
				resourceBean.setGender(rs.getString("Gender"));
				resourceBean.setExperience(rs.getString("Experience"));
				resourceBean.setResumeurl(rs.getString("Resumeurl"));
				resourceBean.setQualification(rs.getString("Qualification"));
				
				resourceBeanAL.add(resourceBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resourceBeanAL;
		
	}



	public ResourceBean getresourceInfo(String id) {
		ResourceBean resourceBean = null;
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Resource where id = ?");
			
			ps.setInt(1, Integer.valueOf(id));
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				resourceBean = new ResourceBean();
				resourceBean.setId(rs.getInt("Id"));
				resourceBean.setName(rs.getString("Name"));
				resourceBean.setEmail(rs.getString("Email"));
				resourceBean.setMobno(rs.getString("Mobno"));
				resourceBean.setGender(rs.getString("Gender"));
				resourceBean.setExperience(rs.getString("Experience"));
				resourceBean.setResumeurl(rs.getString("Resumeurl"));
				resourceBean.setQualification(rs.getString("Qualification"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resourceBean;
		
	}

	public void updateResource(ResourceBean resourceBean) {
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("update Resource set Name=?, Email=?, Mobno=?, Gender=?, Experience=?, Resumeurl=?, Qualification=? where id=?");
			
			ps.setString(1, (resourceBean.getName()));
			ps.setString(2, (resourceBean.getEmail()));
			ps.setString(3, (resourceBean.getMobno()));
			ps.setString(4, (resourceBean.getGender()));
			ps.setString(5, (resourceBean.getExperience()));
			ps.setString(6, (resourceBean.getResumeurl()));
			ps.setString(7, (resourceBean.getQualification()));
			ps.setInt(8,(resourceBean.getId()));
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void deleteResource(String id) {
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("delete from Resource where id=?");
			
			ps.setInt(1, Integer.valueOf(id));
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public ArrayList<ResourceBean> searchResource(String name) {
		ArrayList<ResourceBean> resourceBeanAL = new ArrayList<ResourceBean>();
		ResourceBean resourceBean =null;
		
		Connection con = DbConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select * from Resource where name like ?");
			
			ps.setString(1, name+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				resourceBean = new ResourceBean();
				resourceBean.setId(rs.getInt("Id"));
				resourceBean.setName(rs.getString("Name"));
				resourceBean.setEmail(rs.getString("Email"));
				resourceBean.setMobno(rs.getString("Mobno"));
				resourceBean.setGender(rs.getString("Gender"));
				resourceBean.setExperience(rs.getString("Experience"));
				resourceBean.setResumeurl(rs.getString("Resumeurl"));
				resourceBean.setQualification(rs.getString("Qualification"));
				
				resourceBeanAL.add(resourceBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resourceBeanAL;
	}

	
		
		
	

	

	
}
