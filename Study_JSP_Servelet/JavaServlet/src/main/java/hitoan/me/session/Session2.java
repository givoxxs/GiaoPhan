package hitoan.me.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns="/session2")
public class Session2 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		
		PrintWriter	out = resp.getWriter();
		
		String name = "";
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("name");
		
		if(obj != null) {
            name = String.valueOf(obj);
        } else {
            resp.sendRedirect("/JavaServlet/session1");
        }
		
		// int age = Integer.valueOf(String.valueOf(session.getAttribute("age").toString()));
		int age = (Integer) session.getAttribute("age");
		
		out.println("Hello " + name + " " + age + " from Session2");
	}
}
