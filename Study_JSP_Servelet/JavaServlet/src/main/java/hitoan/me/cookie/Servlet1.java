package hitoan.me.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/servlet1")
public class Servlet1 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		
		out.println("Xin chao cac ban!");
		
		Cookie cookie = new Cookie("username", "hitoan");
		cookie.setMaxAge(5);
		resp.addCookie(cookie);
		
		Cookie cookie2 = new Cookie("age", "20");
		cookie2.setMaxAge(10);
		resp.addCookie(cookie2);
		
		out.println("<br>Da tao cookie thanh cong!");
	}
}
