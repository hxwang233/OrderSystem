package com.dao;

import com.bean.Log;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface LogMapper {
	@Select("select logid,operation,information,operatingtime,operatorid,employeename AS operatorname from log,employee where (operatorid=#{uid} or (beoperatedid=#{uid} and operatorid=0)) and tablename='employee' and employeeno=operatorid")
	public List<Log> employeeLog(int uid);

	   @Select("select logid,tablename,operation,information,operatingtime,operatorid,employeename AS operatorname from log,employee where (operatorid=employeeno)")
	   List <Log> selectAll();
	   
	   @Select("select count(*) from log" )
	   int selectCount();
	   
	
}