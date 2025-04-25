package com.jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseConn {
	public void createStudents()
	{
		String q = "insert into student values(29,'Wriddhi','Satara')";
		try
		{
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			boolean b = stmt.execute(q);
			System.out.println(stmt.execute(q));
			System.out.println(b);
			System.out.println("----------------------");
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void readStudents()
	{
		String q = "select* from student where studId = 23";
		try
		{
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet set = stmt.executeQuery(q);
			System.out.println(set.next());
			
			while(set.next())
			{
				Student std1 = new Student();
				std1.setStudentId(set.getInt("studentId"));
				std1.setStudentName(set.getString("studentName"));
				std1.setStudentAddress(set.getString("studentAddress"));
				System.out.println(std1);
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void getAllStudents()
	{
		ArrayList al = new ArrayList();
		String q = "select* from student";
		
		try
		{
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			
			ResultSet set=stmt.executeQuery(q);
			while(set.next())
			{
				Student std1=new Student();

				std1.setStudentId(set.getInt("studId"));
				std1.setStudentName(set.getString("studName"));
				std1.setStudentAddress(set.getString("studAddress"));
				System.out.println(std1);
				System.out.println("--------------------------------");
				
				al.add(std1);
			}
			
			for(Object o : al)
			{
				System.out.println(o);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public void deleteStudents()
	{
		String q="delete from student where studId=28"; 
		try
		{
			Connection con = ConnectionProvider.getConnection();
			Statement stmt = con.createStatement();
			
			int b = stmt.executeUpdate(q);
			System.out.println(b);
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateStudents()
	{
		
		String q="update student set studAddress ='Thane' where studId=23"; 
		try
		{
			Connection con = ConnectionProvider.getConnection();
			Statement stmt=con.createStatement();
			System.out.println("*************");
			int i=stmt.executeUpdate(q);
			
			if(i > 0)
			{
				System.out.println("record updated");
			}
			con.close();
		}
		catch(Exception e)
		{
			System.out.println("exception occured");
		}
	}
	
	public static void main(String[] args) {
		DatabaseConn d1 = new DatabaseConn();
		d1.createStudents();
		System.out.println("-------------------------------");
		d1.readStudents();
		System.out.println("-------------------------------");
		d1.getAllStudents();
		System.out.println("--------------------------------");
		d1.deleteStudents();
		System.out.println("--------------------------------");
		d1.updateStudents();
	}
}
