package com.service.dao;

import java.util.List;

import com.bean.Orderdetail;

public interface OrderdetailDao {

	public void OrderdetailAdd(List<Orderdetail> orderdetail);
	
	public String OrderdetailSearch(int OrderNo);
	
	public void OrderdetailAlter(List<Orderdetail> orderdetail) ;
	
	public void OrderdetailDelete();
}
