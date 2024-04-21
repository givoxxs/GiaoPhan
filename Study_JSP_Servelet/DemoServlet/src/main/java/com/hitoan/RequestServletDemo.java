package com.hitoan;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/request"})
public class RequestServletDemo extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("Phương thức của request" + req.getMethod());
		
		req.getContentType();
		req.getContextPath();
		System.out.println("Server Name: " + req.getServerName());
		System.out.println("Server Path: " + req.getServletPath());	
		
		Enumeration<String> keys = req.getHeaderNames();
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			System.out.println(key + " : " + req.getHeader(key));
		}
	}
}
