package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Provide the correct details: DBServer/DBName, username, password
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/staffservice", "root", "root");
			System.out.println("Database Connected");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
