package hitoan.me.cookie.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<form action='/JavaServlet/login' method=\"post\">");
		out.println("Username: <input type='text' name='username'><br>");
		out.println("Password: <input type='password' name='password'><br>");
		out.println("<input type='submit' value='sogin'>");
		out.println("</form>");
		
		out.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		if (username.equals("hitoan") && password.equals("123")) {
			Cookie cookie = new Cookie("username", username);
			cookie.setMaxAge(30);
			
			resp.addCookie(cookie);
			resp.sendRedirect("/JavaServlet/welcome");
		} else {
			resp.sendRedirect("/JavaServlet/login");
		}
	}
}
