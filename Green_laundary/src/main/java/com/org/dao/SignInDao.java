package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SignInDao {
	public static int saveSignIn(String name, long mobile,String email,String address, long altmobile, int userid, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/green_laundary", "root",
					"binod");
			String sql = "INSERT INTO newuser values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setLong(2, mobile);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setLong(5, altmobile);
			ps.setInt(6, userid);
			ps.setString(7, password);

			int res = ps.executeUpdate();
			con.close();
			return res;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 0;
	}

	
}


