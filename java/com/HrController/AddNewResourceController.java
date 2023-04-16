package com.HrController;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResourceBean;
import com.dao.HrDao;
import com.filter.Validation;

/**
 * Servlet implementation class AddNewResourceController
 */
@WebServlet("/AddNewResourceController")
public class AddNewResourceController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse responce) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String gender = request.getParameter("gender");
		String[] language = request.getParameterValues("language"); 
		String[] database = request.getParameterValues("database");
		String[] technology = request.getParameterValues("technology");
		String experience = request.getParameter("experience");
		String resumeurl = request.getParameter("resumeurl");
		String qualification = request.getParameter("qualification");
		
		boolean iserror = false;
		//Validation For Name
		if(Validation.isEmpty(name))
		{
			iserror = true;
			request.setAttribute("name", "Name Can't Be Empty");
		}
		else if (Validation.checkLength(name)) {
			iserror = true;
			request.setAttribute("name", "Greter Than 1 Character");
		}
		else if(Validation.isNameAlpha(name))
		{
			iserror = true;
			request.setAttribute("name", "Enter Valid Name");
		}
		else {
			request.setAttribute("namevalue", name);
		}
		
		//Validation For Emial
		if(Validation.isEmpty(email))
	    {
	    	iserror=true;
	    	request.setAttribute("email", "Email Can't Be Empty");
	    }
	    else if(Validation.isEmailAlpha(email))
	    {
	    	iserror=true;
	    	request.setAttribute("hremail", "Enter Valid Email ");
	    }
	    else {
 		   
			request.setAttribute("emailvalue", email);
		
	         }
		
		//Validation For Mobno
		 if(Validation.isEmpty(mobno))
		 {
			 iserror=true;
			 request.setAttribute("mobno", "Mobile No Can't Be Empty");	
		 }
		 else if(Validation.checkMobNoLength(mobno))
		 {
			 iserror=true;
			 request.setAttribute("mobno", "Mobile No Should Be 10 Digit");	
		 }
		 else if(Validation.isMobNoAlpha(mobno))
		 {
			 iserror=true;
			 request.setAttribute("mobno", "Enter Valid MobNo");	
		 }
		 else {
			request.setAttribute("mobnovalue", mobno);
		}
		 
		//Validation for Gender
		 if(Validation.isEmpty(gender))
		 {
			 iserror=true;
			 request.setAttribute("gender", "Please Select Gender");
		 }
		 else {
			request.setAttribute("gendervalue", gender);
		}
		 
		 //Validation For Experience
		 if(experience.matches("[0-9]+")==false)
		 {
			 iserror=true;
			 request.setAttribute("experience", "Enter Valid Experience");
		 }
		 else {
			 request.setAttribute("experiencevalue", experience);
		}
		 
		 //Validation For URL
		 if(Validation.isEmpty(resumeurl))
		 {
			iserror=true;
			request.setAttribute("resumeurl", "URL Can't Be Empty");
		 }
		 else {
			request.setAttribute("resumeurlvalue", resumeurl);
		}
		 
		 //Validation For Qualification
		 if(Validation.isEmpty(qualification))
		 {
			 iserror=true;
			 request.setAttribute("qualification", "Qualification Can't be Empty");
		 }
		 else {
			request.setAttribute("qualificationvalue", qualification);
		}
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 RequestDispatcher rd = null;
		
		if(iserror)
		{
			rd = request.getRequestDispatcher("AddNewResource.jsp");
		}
		else {
			HrDao hrDao = new HrDao();
//			ResourceBean resourceBean = new ResourceBean();
//			resourceBean.setName(name);
//			resourceBean.setEmail(email);
//			resourceBean.setMobno(mobno);
//			resourceBean.setGender(gender);
//			resourceBean.setExperience(experience);
//			resourceBean.setResumeurl(resumeurl);
//			resourceBean.setQualification(qualification);
			
		  int id = hrDao.addResource(name,email,mobno,gender,experience,resumeurl,qualification);
		  System.out.println(id);
		  
		  hrDao.addLanguage(id,language);
		  hrDao.addDatabase(id,database);
		  hrDao.addTechnology(id,technology);
		    
		   rd = request.getRequestDispatcher("HrDashBoard.jsp");
		    
		   
		    
		}
		rd.forward(request, responce);
	}

	
	
	
}
