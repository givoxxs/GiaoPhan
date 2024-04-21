package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet2-test")
public class Servlet2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("hello, this is servlet2");
		
		String name = (String) getServletContext().getAttribute("name");
		
		String jdbc = getServletContext().getInitParameter("jdbc");
		
		out.println("name: " + name + ", jdbc: " + jdbc);
	}
}
