package com.dynamicQuery;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	static Connection con;
	public static Connection connectionProvider()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/capgemini", "root", "Riddhi@23");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
