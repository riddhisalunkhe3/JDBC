package com.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider {
	static Connection con;
	public static Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agce_db", "root", "Riddhi@23");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
