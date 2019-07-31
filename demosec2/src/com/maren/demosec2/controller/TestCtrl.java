package com.maren.demosec2.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestCtrl
 */
@WebServlet("/TestCtrl")
public class TestCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("REQ", "Request Scope");
	    HttpSession session = request.getSession();
	    session.setAttribute("SES", "Session Scope");
	    ServletContext context = getServletContext();
	    context.setAttribute("APP", "Application Scope");
	request.getRequestDispatcher("/TestCtrl3").forward(request, response);
	    
	}

}
