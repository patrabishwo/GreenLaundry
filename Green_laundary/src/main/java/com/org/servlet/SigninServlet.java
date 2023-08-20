package com.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.org.dao.SignInDao;

@WebServlet("/url")
public class SigninServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		long mobile=Long.parseLong(req.getParameter("mobile"));
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		long altmobile=Long.parseLong(req.getParameter("altmobile"));
		int userid = Integer.parseInt(req.getParameter("userid"));
		String password = req.getParameter("password");
		
		

		int res = SignInDao.saveSignIn(name, mobile, email, address, altmobile, userid, password);
		RequestDispatcher rd = req.getRequestDispatcher("signup.html");
		PrintWriter pw = resp.getWriter();
		if (res != 0) {
			pw.write("<html><body><h1>SIGNIN SUCCESSFULLY</h1></body></html>");
			rd.include(req, resp);
		} else {
			pw.write("<html><body><h1>SIGNIN FAILED TRY AGAIN</h1></body></html>");
			rd.include(req, resp);
		}

	}

}
