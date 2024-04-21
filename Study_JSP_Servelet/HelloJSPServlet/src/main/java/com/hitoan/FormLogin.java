package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form-login")
public class FormLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<form action='login' method='post'>");
		out.println("Username: <input type='text' name='username' /><br>");
		out.println("Password: <input type='password' name='password' /><br>");
		out.println("<input type='submit' value='Login' />");
		out.println("</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
	        throws ServletException, IOException {
	    doGet(req, resp);
	}

}
