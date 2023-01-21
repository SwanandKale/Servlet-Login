  package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;

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
		
		 HttpSession hs=request.getSession();
		 User user=(User)hs.getAttribute("user_info");
		 if(user!=null)
		 {
		 pw.write("<h3>Welcome User :: "+user);
		 }
		 else
		 {
			 System.out.println("Session tracking failed");
		 } 
		 hs.invalidate();
		 System.out.println("Session logged out");
		 
	}

}
