package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBconnection {
	private static final String url= "jdbc:mysql://localhost:3306/studentdb";
	private static final String userName= "root"; 
	private static final String pass= "test@123"; //
	
	 public static Connection getConnection() {
	        Connection con = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(url, userName, pass);
	            System.out.println("✅ Database connected successfully!");
	        } catch (ClassNotFoundException e) {
	            System.out.println("❌ MySQL Driver not found: " + e.getMessage());
	        } catch (SQLException e) {
	            System.out.println("❌ Database connection failed: " + e.getMessage());
	        }
	        return con;
	    }

}
