package com.hitoan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		String user = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(user.equals("hitoan") && pass.equals("123")) {
			System.out.println("Login success!");
			
			out.println("<h1>Welcome, " + user + "!</h1>");
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/welcome");
            
			dispatcher.forward(req, resp);
        } else {
        	out.println("<h1>Invalid username or password!</h1>");
        	
        	RequestDispatcher dispatcher = req.getRequestDispatcher("/form-login");
        	
        	dispatcher.include(req, resp);
        }
	}
}
