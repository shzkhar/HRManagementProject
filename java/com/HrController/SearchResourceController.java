package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.ResourceBean;
import com.dao.HrDao;

/**
 * Servlet implementation class SearchResourceController
 */
@WebServlet("/SearchResourceController")
public class SearchResourceController extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		
		ArrayList<ResourceBean> resourceBeanAL = new HrDao().searchResource(name);
		
		RequestDispatcher rd = null;
		if(resourceBeanAL.isEmpty())
		{
			request.setAttribute("msg", "Sorry Data Not Found");
			rd = request.getRequestDispatcher("SearchResource.jsp");
		}
		else {
			request.setAttribute("resourceBeanAL", resourceBeanAL);
			rd = request.getRequestDispatcher("DisplayResourceList.jsp");
		}
		rd.forward(request, response);
		
	}

}
