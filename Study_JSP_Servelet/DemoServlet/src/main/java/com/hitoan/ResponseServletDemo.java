package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/response"})
public class ResponseServletDemo extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/plain");
		
		PrintWriter out = resp.getWriter();
		
		out.println("<h1>Hello, Servlet!</h1>");
		resp.addCookie(new Cookie("name", "hitoan"));
		resp.addHeader("header1", "value1");
		resp.sendError(404, "Error 404");
	}
}
