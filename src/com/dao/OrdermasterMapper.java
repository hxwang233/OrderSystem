package com.dao;

import com.bean.Customer;
import com.bean.Ordermaster;
import com.bean.Product;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrdermasterMapper {
	
	@Select("select * from product where ProductNo=#{ProductNo} and state=1")
	public List<Product> selectProductNo(int productNo);
	
	@Select("select ProductPrice from product where ProductNo=#{ProductNo} and state=1")
	public int selectProductPrice(int ProductNo);
	
	@Select("select * from product where  state=1")
	public List<Product> selectProductNo_null();
	
	@Select("select * from Customer where  state=1")
	public List<Customer> selectCustomerNo();
	
	
	 @Insert("Insert into ordermaster(CustomerNo,SaleNo,Orderdate,Shipdate,InvoiceNo) values(#{customerno},#{saleno},#{orderdate},#{shipdate},#{invoiceno})")
	 public void insertOrdermaster(Ordermaster ordermaster);
	
	 
	 @Select("SELECT LAST_INSERT_ID()")
	 public int selectOrdermasterno();
	 
	 @Update("update ordermaster set state = 0 where OrderNo=#{orderno} ")
	 public void updateOrdermasterdelect(int orderno);
	 	
	 @Update("update ordermaster set Ordersum = #{ordersum} where OrderNo=#{orderno} ")
	 public void updateOrdermastersum(@Param("ordersum")double ordersum,@Param("orderno")int orderno);
	 //����
	    @Select("${sql}")
	    List<Ordermaster> selectSql(@Param("sql")String sql);
	    
	    @Select("${sql}")
	    int selectCount(@Param("sql")String sql);

	    
	  @Select("select * from ordermaster where orderno=#{orderno}")
	  Ordermaster selectOrdermaster(int orderno);
		

		
	 
}