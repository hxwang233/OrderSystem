package com.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.google.gson.Gson;
import com.service.dao.EmployeeManagerDao;
import com.utils.SqlUtil;
import com.utils.TableData;

import net.sf.json.JSONObject;


public class EmployeeManagerImpl implements EmployeeManagerDao{
	
	@Override
	public String initEmployee(int page,int limit) {
		SqlUtil u=new SqlUtil();
		EmployeeMapper employeeMapper=u.getEmployeeMapper();
		int cnt=employeeMapper.selectCount(u.count()+" employee ");
		List<Employee> employees=employeeMapper.selectSql(u.all()+" employee "+u.whereExist()+u.limit(page, limit));
		Gson gson=new Gson();
		TableData obj=new TableData();
		
		obj.setCount(cnt);
		obj.setData(employees);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}

	@Override
	public String getEmployee(String sql) {
		SqlUtil u=new SqlUtil();
		EmployeeMapper employeeMapper=u.getEmployeeMapper();
		int cnt=employeeMapper.selectCount(u.count()+" employee "+sql);
		List<Employee> employees=employeeMapper.selectSql(u.all()+" employee "+sql);
		
		Gson gson=new Gson();
		TableData obj=new TableData();
		
		obj.setCount(cnt);
		obj.setData(employees);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}

}
