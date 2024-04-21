package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
	
	@Override
	public void init() throws ServletException {
	    System.out.println("Starting HelloServlet");
	}
	
	@Override
	public void destroy() {
		System.out.println("Stopping HelloServlet");
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//        System.out.println("HelloServlet service called");
		// TODO Auto-generated method stub
        super.service(request, response);    
        
        System.out.println("HelloServlet service called" + request.getMethod());
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Hello, World!");
		
		out.close();	
	}
}
