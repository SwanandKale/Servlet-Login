package com.pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pojo.User;

/**
 * Servlet implementation class Logged
 */
@WebServlet({ "/Logged", "/log" })
public class Logged extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("In Logout init");
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
		System.out.println("In Logout do get");
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html"); 
		
		pw.write("<h3>Logged Out</h3>");
		
		HttpSession hs=request.getSession();
		System.out.println("Is is a new session in Logout : "+hs.isNew());
		
		User user=(User) hs.getAttribute("user_info");
		System.out.println(user);
		
			
		hs.invalidate();
	}

}
