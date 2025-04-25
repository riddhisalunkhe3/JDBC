package com.jdbcConnection;

public class Student {
	private int studId;
	private String studName;
	private String studAddress;
	
	public void setStudentId(int studId)
	{
		this.studId = studId;
	}
	
	public int getStudentId()
	{
		return studId;
	}
	
	public void setStudentName(String studName)
	{
		this.studName = studName;
	}
	
	public String getStudentName(String studName)
	{
		return studName;
	}
	
	public void setStudentAddress(String studAddress)
	{
		this.studAddress = studAddress;
	}
	
	public String getStudentAddress()
	{
		return studAddress;
	}

	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAddress=" + studAddress + "]";
	}
	
	
}
