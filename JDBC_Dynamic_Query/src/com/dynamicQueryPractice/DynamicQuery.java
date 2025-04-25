package com.dynamicQueryPractice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicQuery {
	Scanner sc = new Scanner(System.in);
	public void createstudentTable()
	{
		String q = "create table student(studentId int(30),studentName varchar(100),studentAdd varchar(100))";
		Connection con = ConnectionProvider.getConnection();
		try 
		{
			Statement stmt = con.createStatement();
			stmt.execute(q);
			System.out.println("table created successfully.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void createStudents()
	{
		System.out.println("Enter student id name and address respectively.");
		Student s = new Student(sc.nextInt(),sc.next(),sc.next());
		String q = "insert into student values(?,?,?)";
		Connection con = ConnectionProvider.getConnection();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, s.getStudentId());
			pstmt.setString(2, s.getStudentName());
			pstmt.setString(3, s.getStudentAdd());
			pstmt.execute();
			System.out.println("Inserted successfully.");
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void readStudentDetails()
	{
		String q = "select* from student where studentId =?";
		System.out.println("Enter the id you want to see data");
		int id = sc.nextInt();
		Connection con = ConnectionProvider.getConnection();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Student s = new Student();
				s.setStudentId(rs.getInt(1));
				s.setStudentName(rs.getString(2));
				s.setStudentAdd(rs.getString(3));
				System.out.println(s);
			}
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void updateStudentAddress()
	{
		System.out.println("enter the id you want to update address");
		int id = sc.nextInt();
		System.out.println("Enter new Address ");
		String add = sc.next();
		String q = "update student set studentAdd=? where studentId=?";
		Connection con = ConnectionProvider.getConnection();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, add);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Address updated successfully");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deleteStudent()
	{
		System.out.println("Enter the id you want to delete the record.");
		int id = sc.nextInt();
		String q = "delete from student where studentId=?";
		Connection con = ConnectionProvider.getConnection();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			pstmt.execute();
			System.out.println("Record deleted.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
