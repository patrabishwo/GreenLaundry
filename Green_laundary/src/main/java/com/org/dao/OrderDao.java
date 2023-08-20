package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDao {
	public static int saveOrder(String name, long mobile, String address, String email, String pickupdate, String pickuptime ) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/green_laundary", "root",
					"binod");
			String sql = "INSERT INTO orders values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setLong(2, mobile);
			ps.setString(3, address);
			ps.setString(4, email);
			ps.setString(5, pickupdate);
			ps.setString(6, pickuptime);

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

