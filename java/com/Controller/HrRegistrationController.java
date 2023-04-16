package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AdminDao;
import com.filter.Validation;

/**
 * Servlet implementation class HrRegistrationController
 */
@WebServlet("/HrRegistrationController")
public class HrRegistrationController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hrname = request.getParameter("hrname");
		String hremail = request.getParameter("hremail");
		String hrpassword = request.getParameter("hrpassword");
		String hrmobno = request.getParameter("hrmobno");
		
		boolean iserror = false;
		if(Validation.isEmpty(hrname))
		{
			iserror=true;
			request.setAttribute("hrname", "Name Can't Be Empty");
		}
		else if(Validation.checkLength(hrname))
		{
			iserror=true;
			request.setAttribute("hrname", "Enter More Than One Character");
		}
		else if(Validation.isNameAlpha(hrname))
		{
			iserror=true;
			request.setAttribute("hrname", "Enter Valid Name");
		}
		else {
			request.setAttribute("hrnamevalue", hrname);
		}
		
		//Validation For Email
		 if(Validation.isEmpty(hremail))
		    {
		    	iserror=true;
		    	request.setAttribute("hremail", "Email Can't Be Empty");
		    }
		    else if(Validation.isEmailAlpha(hremail))
		    {
		    	iserror=true;
		    	request.setAttribute("hremail", "Enter Valid Email ");
		    }
		    else {
	 		   
				request.setAttribute("hremailvalue", hremail);
			
		         }
		 
		 //Validation for Password
		 if(Validation.isEmpty(hrpassword))
		    {
		    	iserror=true;
		    	request.setAttribute("hrpassword", "Password Can't Be Empty");
		    }
		    else if(Validation.isPasswordalpha(hrpassword))
		    {
		    	iserror=true;
	    		request.setAttribute("hrpassword", "Enter Valid Password");	
		    }
		   	else 
		   	{
		    	   
					request.setAttribute("hrpasswordvalue", hrpassword);
			}
		 
		 //Validation For MobNo
		 if(Validation.isEmpty(hrmobno))
		 {
			 iserror=true;
			 request.setAttribute("hrmobno", "Mobile No Can't Be Empty");	
		 }
		 else if(Validation.checkMobNoLength(hrmobno))
		 {
			 iserror=true;
			 request.setAttribute("hrmobno", "Mobile No Should Be 10 Digit");	
		 }
		 else if(Validation.isMobNoAlpha(hrmobno))
		 {
			 iserror=true;
			 request.setAttribute("hrmobno", "Enter Valid MobNo");	
		 }
		 else {
			request.setAttribute("hrmobnovalue", hrmobno);
		}
		 
		 
		 RequestDispatcher rd=null;
		 if(iserror)
		 {
			 rd=request.getRequestDispatcher("AddHr.jsp");
		 }
		 else {
			AdminDao adminDao = new AdminDao();
			String check = adminDao.addHr(hrname,hremail,hrpassword,hrmobno);
			
		   if(check.equals("email")){
				request.setAttribute("error","This Email is Already exist" );
				rd=request.getRequestDispatcher("AddHr.jsp");
			}
			else if(check.equals("mobno")){
				request.setAttribute("error","This MobileNo is Already exist" );
				rd=request.getRequestDispatcher("AddHr.jsp");
			}
			else {
				 rd=request.getRequestDispatcher("HrAddesSuccessfully.jsp");
			}
			}
			
			rd.forward(request, response);
		}

}


