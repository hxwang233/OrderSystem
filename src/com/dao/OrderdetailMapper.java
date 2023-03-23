package com.dao;

import com.bean.Orderdetail;

import com.bean.OrderdetailKey;
import com.bean.Ordermaster;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OrderdetailMapper {
	   @Select("${sql}")
	   int selectCount(@Param("sql")String sql);
	   
	 @Select("select * from Orderdetail where OrderNo=#{OrderNo}  ")
	 public  List<Orderdetail> selectOrderdetailON(int OrderNo);
	 
	  @Insert("Insert into Orderdetail(OrderNo,ProductNo,Qty,Price) values(#{orderno},#{productno},#{qty},#{price})")
	 public void insertOrderdetailIn(Orderdetail Orderdetail);

	  @Update("update Orderdetail set Qty = #{qty},Price = #{price} where ProductNo = #{productno} and OrderNo=#{orderno}" )
	  public void updateOrderdetailup(Orderdetail Orderdetail);
	  
	  @Update("update OrderMaster set Ordersum=(select sum(Qty*Price) from orderdetail where orderno=#{orderno}) where orderno=#{orderno} ")
	  public void updateOrdersum(int orderno);
}