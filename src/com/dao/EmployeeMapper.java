package com.dao;

import com.bean.Employee;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;


public interface EmployeeMapper {
   @Select("select * from employee")
   List<Employee> selectAll();
   
   @Select("${sql}")
   List<Employee> selectSql(@Param("sql")String sql);
   
   @Select("${sql}")
   int selectCount(@Param("sql")String sql);
   
  
   @Insert("insert into employee (Employeename,Sex,Department,Headship,Birthday,Salary,Address,Telephone)values(#{employeename},#{sex},#{department},#{headship},#{birthday},#{salary},#{address},#{telephone})")
   @Options(useGeneratedKeys=true,keyProperty="employeeno",keyColumn="employeeno")
   int insert(Employee employee);
	
   @Select("select * from employee where EmployeeNo=#{EmployeeNo}")
   int selectE(int EmployeeNo);
	
   //@Update("Update employee set EmployeeNo=#{EmployeeNo},Employeename=#{Employeename},Sex=#{Sex},Department=#{Department},Headship=#{Headship},Hiredate=#		{Hiredate},Birthday=#{Birthday},Salary=#{Salary},Address=#{Address},Telephone=#{Telephone}")
   //int updateInfo(Employee employee);
	
   @Update("update employee set state=0 where EmployeeNo=#{EmployeeNo}")
   int deleteE(int employeeno);

   @Select("select * from employee where EmployeeNo=#{id}")
   Employee selectI(@Param("id") int id); 
   
 //员工自己修改
   @Select({"call staff_update_employee_log(#{eno,mode=IN,jdbcType=INTEGER},"
	   +"#{Newbirthday,mode=IN,jdbcType=DATE},"
	   +"#{Newaddress,mode=IN,jdbcType=VARCHAR},"
	   +"#{Newtelephone,mode=IN,jdbcType=VARCHAR})"
   })
   @Options(statementType=StatementType.CALLABLE)
   void SUpdate(Map<String,Object> params) ;

   
   //管理员修改
   @Select({"call admin_update_employee_log(#{eno,mode=IN,jdbcType=INTEGER},"
	   +"#{Newdepartment,mode=IN,jdbcType=VARCHAR},"
	   +"#{Newheadship,mode=IN,jdbcType=VARCHAR},"
	   +"#{Newsalary,mode=IN,jdbcType=DECIMAL},"
	   +"#{operatorID,mode=IN,jdbcType=INTEGER})"  
   })
   @Options(statementType=StatementType.CALLABLE)
    void AUpdate(Map<String,Object> params) ;

   @Select("select * from employee where employeeno=#{employeeno}")
   Employee selectMessage(int employeeno);
   
}