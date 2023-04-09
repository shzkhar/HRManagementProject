 package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.AdminBean;
import com.dao.AdminDao;

/**
 * Servlet implementation class AdminAuthenticationController
 */
@WebServlet("/AdminAuthenticationController")
public class AdminAuthenticationController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email = request.getParameter("email");
	    String password=  request.getParameter("password");
	   
	    
	    boolean iserror=false;
	    if(email==null || email.trim().length()==0)
	    {
	    	iserror=true;
	    	request.setAttribute("email1", "Email Can't Be Empty");
	    }
	    else 
	    {
	    	String alpha = "^(.+)@(\\S+)$";
	    	if(email.matches(alpha)==false)
	    	{
	    		iserror=true;
		    	request.setAttribute("email1", "Enter Valid Email ");	
	    	}
	    	else {
	    		   
	    			request.setAttribute("emailvalue", email);
	    		
			}
	    	
	    }
	    
	    if(password==null || password.trim().length()==0)
	    {
	    	iserror=true;
	    	request.setAttribute("password1", "Password Can't Be Empty");
	    }
	    else
	    {
	    	String alpha = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*$%^&+=])(?=\\S+$).{8,}$";
	    	if(password.matches(alpha)==false)
	    	{
	    		iserror=true;
	    		request.setAttribute("password1", "Enter Valid Password");
	    	}
	    	else {
	    	   
				request.setAttribute("passwordvalue", password);
			}
	    	
	    }
	    
	    RequestDispatcher rd;
	    if(iserror)
	    {
	    	rd = request.getRequestDispatcher("AdminLogin.jsp");
	    }
	    else {
	    	AdminDao adminDao = new AdminDao();
	    	
	    	AdminBean adminBean = adminDao.authenticate(email,password);
         
	    	if(adminBean==null)
           {  
        	   rd = request.getRequestDispatcher("AdminLogin.jsp");
           }
           else {
			 request.setAttribute("adminBean", adminBean);
         	 rd = request.getRequestDispatcher("AddHr.jsp");
		}
		}
	    rd.forward(request, response);
	}

}
