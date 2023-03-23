package com.utils;

import java.util.List;
import java.util.Map;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;

import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.dao.Mapper;
import com.google.gson.Gson;

public class Pagination {
	private int cnt;
	private List<?> list;
	private String table;
	private int page;
	private int limit;
	private Mapper mapper;
	public Pagination(int page,int limit,String table,Mapper mapper) {
		this.page=page;
		this.limit=limit;
		this.mapper=mapper;
		this.table=table;
		this.cnt=mapper.selectCount(SqlUtil.count()+" "+table+" "+SqlUtil.whereExist());
	}

	public String initList() {
		if(table.equals("employee")) {
			list= mapper.selectEmployeeSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
		}
		else if(table.equals("log")) {
			list= mapper.selectLogSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
		}
		else if(table.equals("customer")) {
			list= mapper.selectCustomerSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
		}
		else if(table.equals("product")) {
			list= mapper.selectProductSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
		}
		Gson gson=new Gson();
		TableData obj=new TableData();
		obj.setCount(cnt);
		obj.setData(list);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}
	
	
	public String initList(Map<String,Object> inrequire) {
		if(inrequire.isEmpty()) {
			if(table.equals("employee")) {
				list= mapper.selectEmployeeSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
			}
			else if(table.equals("log")) {
				list= mapper.selectLogSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
			}
			else if(table.equals("customer")) {
				list= mapper.selectCustomerSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
			}
			else if(table.equals("product")) {
				list= mapper.selectProductSql(SqlUtil.all()+" "+table+" "+SqlUtil.whereExist()+SqlUtil.limit(page, limit));
			}
		}
		else {
			String str=SqlUtil.quire(inrequire);			
			if(table.equals("employee")) {
				list= mapper.selectEmployeeSql(SqlUtil.all()+" "+table+" "+str+SqlUtil.limit(page, limit));
			}
			else if(table.equals("log")) {
				list= mapper.selectLogSql(SqlUtil.all()+" "+table+" "+str+SqlUtil.limit(page, limit));
			}
			else if(table.equals("customer")) {
				list= mapper.selectCustomerSql(SqlUtil.all()+" "+table+" "+str+SqlUtil.limit(page, limit));
			}
			else if(table.equals("product")) {
				list= mapper.selectProductSql(SqlUtil.all()+" "+table+" "+str+SqlUtil.limit(page, limit));
			}
		}
		Gson gson=new Gson();
		TableData obj=new TableData();
		obj.setCount(cnt);
		obj.setData(list);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}
}
