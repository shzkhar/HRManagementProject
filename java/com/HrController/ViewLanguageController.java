package com.HrController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HrDao;

/**
 * Servlet implementation class ViewLanguageController
 */
@WebServlet("/ViewLanguageController")
public class ViewLanguageController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		
		ArrayList languageAL = new HrDao().viewLanguage(id);
		
		request.setAttribute("languageAL", languageAL);
		request.setAttribute("check", "Language");
		request.getRequestDispatcher("LDTViewPage.jsp").forward(request, response);
	}

	

}
