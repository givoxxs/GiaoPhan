package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = { "/servlet-config" }, initParams = { 
//		@WebInitParam(name = "name", value = "hitoan")
//})
public class ServletConfigDemo extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		System.out.println("Hello, ServletConfigDemo!");
		String name = super.getServletConfig().getInitParameter("name");
		resp.setContentType("text/plain");
		PrintWriter out = resp.getWriter();
		out.println("Xin chào: " + name);
		out.println(getServletConfig().getServletName());
	}
}
