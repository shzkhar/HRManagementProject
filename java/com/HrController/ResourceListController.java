package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResourceBean;
import com.dao.HrDao;

/**
 * Servlet implementation class ResourceListController
 */
@WebServlet("/ResourceListController")
public class ResourceListController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    ArrayList<ResourceBean> resourceBeanAL = new HrDao().getAllResources();	
	    
	    request.setAttribute("resourceBeanAL", resourceBeanAL);
	    
	    request.getRequestDispatcher("DisplayResourceList.jsp").forward(request, response);
	}

	

}
