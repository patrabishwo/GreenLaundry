package com.org.servlet;
import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.ContactDao;


@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile =Long.parseLong(req.getParameter("mobile")) ;
		String email = req.getParameter("email");
		System.out.println(req.getParameter("email"));
		

		int res = ContactDao.saveContact(name, mobile, email);
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		PrintWriter pw =resp.getWriter();
		if (res != 0) {
			rd.include(req, resp);
			pw.write("<html><body><h1>We Contact You As Soon As Possible</h1></body><html>");
		} else {
			pw.write("<html><body><h1>We Contact You As Soon As Possible</h1></body></html>");
			rd.include(req, resp);
		}	
	}
	

}