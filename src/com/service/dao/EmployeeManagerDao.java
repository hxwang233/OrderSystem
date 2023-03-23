package com.service.dao;

public interface EmployeeManagerDao {
	String initEmployee(int page,int limit);
	String getEmployee(String sql);
	
}
