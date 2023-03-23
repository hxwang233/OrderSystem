package com.dao;

import com.bean.Customer;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

public interface CustomerMapper {
	
	//插入客户
	@Select({"call insert_customer_log(#{cname,mode=IN,jdbcType=VARCHAR},"
			+"#{address,mode=IN,jdbcType=VARCHAR},"
			+"#{telephone,mode=IN,jdbcType=VARCHAR},"
			+"#{zip,mode=IN,jdbcType=VARCHAR},"
			+"#{operatorId,mode=IN,jdbcType=INTEGER})"
		})
	@Options(statementType=StatementType.CALLABLE)
	public void insert(Map<String,Object> params);
	
	//删除客户
	@Select({"call delete_customer_log(#{cno,mode=IN,jdbcType=INTEGER},"
			+"#{operatorId,mode=IN,jdbcType=INTEGER})"
		})
	@Options(statementType=StatementType.CALLABLE)
	public void delete(Map<String,Object> params);
	
	//修改客户
	@Select({"call update_customer_log(#{cno,mode=IN,jdbcType=INTEGER},"
			+"#{cname,mode=IN,jdbcType=VARCHAR},"
			+"#{newaddress,mode=IN,jdbcType=VARCHAR},"
			+"#{tel,mode=IN,jdbcType=VARCHAR},"
			+"#{newzip,mode=IN,jdbcType=VARCHAR},"
			+"#{operatorId,mode=IN,jdbcType=INTEGER})"
		})
	@Options(statementType=StatementType.CALLABLE)
	public void update(Map<String, Object> params);
	
	
	//@Insert("insert into customer(CustomerName,Address,Telephone,Zip) values(#{customername},#{address},#{telephone},#{zip})")
	//public int insert(Customer customer);
	
	//@Delete("delete from customer where customerNo=#{customerNo}")
	//public int delete(int customerNo);
	
	//@Update("update customer set customername=#{customername},address=#{address},telephone=#{telephone},zip=#{zip} where customerno=#{customerno}")
	//public int update(Customer customer);
	
	@Select("select * from customer")
	public List<Customer> selectAll(); 
	
	@Select("select * from customer where customerNo=#{customerNo}")
	public Customer select(int customerNo); 
	
	@Select("select * from customer where customername like CONCAT('%',#{str},'%')")
	public List<Customer> blurrySelectName(String str);
	
}	
