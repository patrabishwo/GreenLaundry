package com.org.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;

public class ContactDao extends HttpServlet{
	public static int saveContact(String name,long mobile,String email) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/green_laundary", "root",
					"binod");
			String sql = "INSERT INTO help VALUES(?, ?, ?)";
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setLong(2, mobile);
			ps.setString(3, email);
			int res=ps.executeUpdate();
			con.close();
			return res;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return 0;
	}

}



