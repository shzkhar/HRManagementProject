package com.HrController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResourceBean;
import com.dao.HrDao;

/**
 * Servlet implementation class EditResourceController
 */
@WebServlet("/EditResourceController")
public class EditResourceController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
	    ResourceBean resourceBean = new HrDao().getresourceInfo(id);
	    
	    request.setAttribute("resourceBean", resourceBean);
	    request.getRequestDispatcher("EditResource.jsp").forward(request, response);
	}
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String mobno = request.getParameter("mobno");
		String gender = request.getParameter("gender");
		String experience = request.getParameter("experience");
		String url = request.getParameter("resumeurl");
		String qualification = request.getParameter("qualification");
		
		ResourceBean resourceBean = new ResourceBean();
		
		resourceBean.setId(Integer.valueOf(id));
		resourceBean.setName(name);
		resourceBean.setEmail(email);
		resourceBean.setGender(gender);
		resourceBean.setMobno(mobno);
		resourceBean.setExperience(experience);
		resourceBean.setResumeurl(url);
		resourceBean.setQualification(qualification);
		
		 new HrDao().updateResource(resourceBean);
		
		
			response.sendRedirect("ResourceListController");
		
		
		
		}

	
}
