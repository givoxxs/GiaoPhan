package me.hitoan.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.hitoan.connection.DbCon;
import me.hitoan.dao.OrderDao;
import me.hitoan.model.Cart;
import me.hitoan.model.Order;
import me.hitoan.model.User;

/**
 * Servlet implementation class OrderNowServlet
 */
@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			User user = (User) request.getSession().getAttribute("auth");
			if (user != null) {
				String productId = request.getParameter("id");
				int productQuantity = Integer.parseInt(request.getParameter("quantity"));
				
				if (productQuantity <= 0) {
					productQuantity = 1;
				}
				
				Order orderModel = new Order();
				orderModel.setId(Integer.parseInt(productId));
				orderModel.setUserId(user.getId());
				orderModel.setQuantity(productQuantity);
				orderModel.setDate(sdf.format(date));
				
				OrderDao orderDao = new OrderDao(DbCon.getConnection());
				boolean status = orderDao.insertOrder(orderModel);
				
				if (status) {
//					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//					if (cart_list != null) {
//						for (Cart c : cart_list) {
//							if (c.getId() == Integer.parseInt(productId)) {
//								cart_list.remove(cart_list.indexOf(c));
//								break;
//							}
//						}
//					}
					
					response.sendRedirect("orders.jsp");
				} else {
					out.println("Failed to order product");
				}
				
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
