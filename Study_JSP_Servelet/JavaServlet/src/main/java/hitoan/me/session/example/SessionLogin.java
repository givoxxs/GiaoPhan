package hitoan.me.session.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/sessionLogin")
public class SessionLogin extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<form action='/JavaServlet/sessionLogin' method='post'>");
		out.println("Username: <input type='text' name='username' />");
		out.println("Password: <input type='password' name='password' />");
		out.println("<input type='submit' value='Login' />");
		out.println("</form>");	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		if (username.equals("hitoan") && password.equals("123456")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			
			resp.sendRedirect("/JavaServlet/welcomeSession");
		} else {
			resp.sendRedirect("/JavaServlet/sessionLogin");
		}
	}
}
