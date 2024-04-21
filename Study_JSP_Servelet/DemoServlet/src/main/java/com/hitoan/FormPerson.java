package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/form-user"})
public class FormPerson extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<form action='/DemoServlet/add-user' method='get'>");
		out.println("<label for='name'>Name:</label>");
		out.println("<input type='text' name='name' id='name'><br>");
		out.println("<label for='age'>Age:</label>");
		out.println("<input type='text' name='age' id='age'><br>");
		out.println("<label for='address'>Address:</label>");
		out.println("<input type='text' name='address' id='address'><br>");
		out.println("<input type='submit' value='submit'>");
		out.println("</form>");
	}
}
