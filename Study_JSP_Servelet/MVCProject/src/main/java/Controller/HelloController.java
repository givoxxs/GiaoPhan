package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.User;

@WebServlet(urlPatterns = {"/hello", "/xin-chao", "/hi"})
public class HelloController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = "Phan Văn Toàn";
		
		User user = new User();
		user.setName(name);
		user.setAddress("Thừa Thiên Huế");
		
		req.setAttribute("name", name);
		req.setAttribute("user", user);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("hello.jsp");
		dispatcher.forward(req, resp);
	}
}
