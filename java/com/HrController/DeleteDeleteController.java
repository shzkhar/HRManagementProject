package com.HrController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;

/**
 * Servlet implementation class DeleteDeleteController
 */
@WebServlet("/DeleteDeleteController")
public class DeleteDeleteController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		new HrDao().deleteResource(id);
		
		response.sendRedirect("ResourceListController");
	}

	
}
