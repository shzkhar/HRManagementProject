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
 * Servlet implementation class ViewResourceController
 */
@WebServlet("/ViewResourceController")
public class ViewResourceController extends HttpServlet {
	

	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         String id = request.getParameter("id");
		
		
		ResourceBean resourceBean =new HrDao().getresourceInfo(id);
		
		request.setAttribute("resourceBean", resourceBean);
		request.getRequestDispatcher("ViewResource.jsp").forward(request, response);
		}

}
