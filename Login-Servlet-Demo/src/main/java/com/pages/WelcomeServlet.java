package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet({ "/WelcomeServlet", "/welcome" })
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		pw.write("<h3>Welcome to servlet</h3>");
		 Cookie[]cks=request.getCookies();
		 
		 String username=null; String email=null;
		 
		 for(Cookie c:cks)
		 {
			 if(c.getName().equals("username"))
			 {
				 username=c.getValue();
			 }
			 if(c.getName().equals("email"))
			 {
				 email=c.getValue();
			 }
		 }
		 
		 pw.write("<h3>Welcome User :: "+username);
		 pw.write("<h3>User Email :: "+email);
	}

}
