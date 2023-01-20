package com.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dal.DbConnector;
import com.dal.LoginManager;
import com.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value="/loginservlet", loadOnStartup = -1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	LoginManager log;
	
	public void init(ServletConfig config) throws ServletException {
		System.out.println("In init method");
		try {
			
//			DbConnector.openConnection();
			log=new LoginManager();
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			DbConnector.closeConnection();
			log.closeSt();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In do method method");
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password"); 
		
		
		try {
			User user=log.validateUser(username, password);
			System.out.println(user+"In login srvlet ");
			if(user !=null)
			{
				pw.write("<h3> Successful Login </h3>");
				pw.write("<h3>"+user.getName()+"</h3>");	
				//page navigation technique : client pool tech internal navigate to another servlet
				
				//maintainer user specific data scross multiple request
				Cookie ck1=new Cookie("username",user.getName());
				Cookie ck2=new Cookie("email", user.getEmail());
				
				response.addCookie(ck1);
				response.addCookie(ck2);
	
				
				response.sendRedirect("welcome");
			}
			else
			{
				pw.write("<h3>Unsuccesful Attempt</h3>");
				pw.write("<h3><a href='login.html'>Retry</a></h3>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
