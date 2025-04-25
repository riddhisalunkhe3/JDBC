package com.dynamicQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DynamicQuery {
	Scanner sc = new Scanner(System.in);
	public void createEmployeeTable()
	{
		try 
		{
			Statement stmt = DBConnection.connectionProvider().createStatement();
			stmt.executeUpdate("create table employee(empId int(30),empName varchar(100),empSalary int(50),empAdd varchar(100))");
			System.out.println("Created table successfully.");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void createEmployee()
	{
		System.out.println("Enter empId , empName ,empSalary and empAdd respectively.");
		Employee e = new Employee(sc.nextInt(),sc.next(),sc.nextInt(),sc.next());
		String q = "insert into employee values(?,?,?,?)";
		Connection con = DBConnection.connectionProvider();
		
		try
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1,e.getEmpId());
			pstmt.setString(2, e.getEmpName());
			pstmt.setInt(3, e.getEmpSalary());
			pstmt.setString(4, e.getEmpAdd());
			pstmt.execute();
			System.out.println("Inserted successfully.");
			con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	}
	
	public void readEmployee()
	{
		String q ="select* from employee where empId =?";
		System.out.println("Enter the id you want to read data");
		int id = sc.nextInt();
		Connection con = DBConnection.connectionProvider();
		try
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				Employee e = new Employee();
				e.setEmpId(rs.getInt(1));
				e.setEmpName(rs.getString(2));
				e.setEmpSalary(rs.getInt(3));
				e.setEmpAdd(rs.getString(4));
				System.out.println(e);
			}
			con.close();
		} 
		catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	
	public void updateEmployeeAddress()
	{
		System.out.println("Enter id you want to update address");
		int id = sc.nextInt();
		System.out.println("Enter new Address : ");
		String add = sc.next();
		
		String q = "update employee set empAdd = ? where empId = ?";
		Connection con = DBConnection.connectionProvider();
		try 
		{
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setString(1, add);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			System.out.println("Address updated successfully.");
			con.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deleteEmployee()
	{
		String q = "delete from employee where empId = ?";
		System.out.println("Enter id you want to delete : ");
		int id = sc.nextInt();
		Connection con = DBConnection.connectionProvider();
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
