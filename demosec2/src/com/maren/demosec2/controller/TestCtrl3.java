package com.maren.demosec2.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestCtrl3
 */
@WebServlet("/TestCtrl3")
public class TestCtrl3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @param <PrintWriter>
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String req=(String)request.getAttribute("REQ");
		String ses=(String)request.getAttribute("SES");
		String app=(String)request.getAttribute("APP");
		response.getWriter().append("Request Scope"+req);
		response.getWriter().append("Session Scope"+ses);
		response.getWriter().append("Application Scope"+app);
	}

}
