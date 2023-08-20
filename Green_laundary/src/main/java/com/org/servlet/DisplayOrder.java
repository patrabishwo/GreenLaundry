package com.org.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/request")
public class DisplayOrder extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/green_laundary?user=root&password=binod");
			String sql = "SELECT *FROM orders";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			PrintWriter pw = resp.getWriter();
			pw.write("<html><body>");
			pw.write("<table border=3px>");
			pw.write("<tr>");
			pw.write("<th>NAME</th>");
			pw.write("<th>MOBILE</th>");
			pw.write("<th>ADDRESS</th>");
			pw.write("<th>EMAIL</th>");
			pw.write("<th>PICKUPDATE</th>");
			pw.write("<th>PICKUPTIME</th>");
			
			pw.write("</tr>");

			while (rs.next()) {
				pw.write("<tr>");
				pw.write("<td>" + rs.getString(1) + "</td>");
				pw.write("<td>" + rs.getLong(2) + "</td>");
				pw.write("<td>" + rs.getString(3) + "</td>");
				pw.write("<td>" + rs.getString(4) + "</td>");
				pw.write("<td>" + rs.getString(5) + "</td>");
				pw.write("<td>" + rs.getString(6) + "</td>");
				
				pw.write("</tr>");
			}
			pw.write("</table></body></html>");
			con.close();

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}