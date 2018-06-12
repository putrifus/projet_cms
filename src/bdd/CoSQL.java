package bdd;

import java.sql.*;

public class CoSQL {
	private CoSQL co = new CoSQL();
	private static String url = "jdbc:mysql://localhost:3306/CMS?useSSL=false";
	private static Connection con = null;

	private CoSQL() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getInstance() {
		if (con == null) {
			try {
				con = DriverManager.getConnection(url, "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}