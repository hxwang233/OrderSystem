package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bean.Customer;
import com.bean.Employee;
import com.bean.Log;
import com.bean.Product;

public interface Mapper {
	   @Select("${sql}")
	   List<Employee> selectEmployeeSql(@Param("sql")String sql);
	   
	   @Select("${sql}")
	   List<Customer> selectCustomerSql(@Param("sql")String sql);
	   
	   @Select("${sql}")
	   List<Log> selectLogSql(@Param("sql")String sql);
	   
	   @Select("${sql}")
	   List<Product> selectProductSql(@Param("sql")String sql);
   
	   @Select("${sql}")
	   int selectCount(@Param("sql")String sql);
}
