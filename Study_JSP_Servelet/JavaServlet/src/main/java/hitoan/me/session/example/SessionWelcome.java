package hitoan.me.session.example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/welcomeSession")
public class SessionWelcome extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name = "";
		
		HttpSession session = req.getSession();
		
		Object obj = session.getAttribute("username");
		
		if (obj != null) {
			name = obj.toString();
		} else {
			resp.sendRedirect("/JavaServlet/sessionLogin");
		}
		
		out.println("Welcome " + name + "!");
		out.println("<br />");
		out.println("Log out: <a href='/JavaServlet/sessionLogout'>Logout</a>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
	}
}
