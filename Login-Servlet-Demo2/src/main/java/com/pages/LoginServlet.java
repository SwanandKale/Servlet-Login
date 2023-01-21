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
import javax.servlet.http.HttpSession;

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
		System.out.println("In do method Login servlet");
		
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String username=request.getParameter("username");
		String password=request.getParameter("password"); 
		
		
		try {
			User user=log.validateUser(username, password);
			System.out.println(user+"In login srvlet ");
			if(user !=null)
			{
//				pw.write("<h3> Successful Login </h3>");
//				pw.write("<h3>"+user.getName()+"</h3>");	
				//page navigation technique : client pool tech internal navigate to another servlet
				
				//get Http session obj from web container
				HttpSession hs=request.getSession();
				hs.setAttribute("user_info", user); 
				
				System.out.println("session created"+hs.getId());
				System.out.println("Session created : "+hs.isNew());
				
				
				
				
				//client pool technique : response.sendRedirect("welcome ");
				response.sendRedirect("welcome");
			}
			else
			{
				System.out.println("Unsuccesfull attempt ");
				pw.write("<h3>Unsuccesful Attempt</h3>");
				pw.write("<h3><a href='login.html'>Retry</a></h3>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
