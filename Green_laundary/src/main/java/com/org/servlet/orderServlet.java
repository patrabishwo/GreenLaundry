package com.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.OrderDao;


@WebServlet("/save")
public class orderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String address = req.getParameter("address");
		String email = req.getParameter("email");
		String pickupdate = req.getParameter("pickupdate");
		String pickuptime = req.getParameter("pickuptime");
		
		
		

		int res = OrderDao.saveOrder(name, mobile, address, email, pickupdate, pickuptime);
		RequestDispatcher rd = req.getRequestDispatcher("signup.html");
		PrintWriter pw = resp.getWriter();
		if (res != 0) {
			pw.write("<html><body><h1>ORDERED  SUCCESSFULLY</h1></body></html>");
			rd.include(req, resp);
		} else {
			pw.write("<html><body><h1>SOMETHING WENT WRONG!!!!!!!!!!!</h1></body></html>");
			rd.include(req, resp);
		}

	}

}