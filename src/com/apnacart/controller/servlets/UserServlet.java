package com.apnacart.controller.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.RequestDispatcher;

import com.apnacart.model.service.UserIdentity;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserIdentity userIdentityObj = new UserIdentity();
		if(request.getParameter("doRegister") != null) {
			
			//retrieving the username and password from Register.jsp
			String userName = request.getParameter("username");
	        String password = request.getParameter("password");	
			userIdentityObj.doRegister( userName, password );
			
		}
		
		if(request.getParameter("doLogin") != null) {
			
			//retrieving the username and password from Login.jsp
			
			String userName = request.getParameter("userName");
	        String password = request.getParameter("password");	
	        if(userIdentityObj.doLogin( userName, password ) != false){
	        	HttpSession session = request.getSession(true); 
				session.setAttribute("user", userName);
				session.setMaxInactiveInterval(25);
				
				RequestDispatcher rd = request.getRequestDispatcher("ProductServlet");
				rd.forward(request, response);
	        }
	        else {
	        	request.setAttribute("message", "Invalid credentials! Please try again." );
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
	        	
	        }			
		}
		if(request.getParameter("doLogout") != null) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("Your Session has expired!");
			out.println("<br><br>");
			out.println("<a href = \"Login.jsp\">Click here to login again</a>");
			out.println("</body></html>");
			HttpSession session = request.getSession(false);
			session.removeAttribute("user");
			session.getMaxInactiveInterval();			
		}
		
	}

}
