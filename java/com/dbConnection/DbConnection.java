package com.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static Connection getConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			 con = DriverManager.getConnection("jdbc:sqlserver://localhost:50996;trustServerCertificate=true;","sa", "root");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
//	public static void main(String[] args) {
//		Connection con = getConnection();
//		if(con!=null)
//		{
//			System.out.println("Perfect");
//		}
//		else {
//			System.out.println("Not Perfect");
//		}
//	}
}
