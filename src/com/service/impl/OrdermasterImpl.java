package com.service.impl;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.bean.Customer;
import com.bean.Ordermaster;
import com.bean.Product;
import com.dao.OrdermasterMapper;
import com.google.gson.Gson;
import com.service.dao.OrdermasterDao;
import com.utils.SqlUtil;
import com.utils.TableData;

public class OrdermasterImpl implements OrdermasterDao{
	SqlSession session;
	SqlUtil s;
	OrdermasterMapper q;
	public OrdermasterImpl() {
		s= new SqlUtil();
		q=new SqlUtil().getOrdermasterMapper();
	}
	
	public String initOrderMaster(int page,int limit,String condition) {
		OrdermasterMapper ordermasterMapper=s.getOrdermasterMapper();
		int cnt=ordermasterMapper.selectCount(s.count()+" ordermaster ");
		List<Ordermaster> orders=q.selectSql(s.all()+"ordermaster where state = 1 "+condition+s.limit(page, limit));
		Gson gson=new Gson();
		TableData obj=new TableData();
		
		obj.setCount(cnt);
		obj.setData(orders);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}
	public String getProduct(int page,int limit,String condition,String ProductNo) {
		
		OrdermasterMapper ordermasterMapper=s.getOrdermasterMapper();
		int cnt=ordermasterMapper.selectCount(s.count()+" ordermaster ");
		//System.out.println(ProductNo);
		List<Product> products;
		if(ProductNo==null)
		{
			products=q.selectProductNo_null();
		}
		else 
		{
			int p=Integer.parseInt(ProductNo);
			products=q.selectProductNo(p);
		}
		Gson gson=new Gson();
		TableData obj=new TableData();
		
		obj.setCount(cnt);
		obj.setData(products);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}
public int getProductPrice(String ProductNo) {
				
		int p=Integer.parseInt(ProductNo);
		System.out.println(p);
		return q.selectProductPrice(p);
	}

public String getCustomer(int page,int limit,String condition) {
		
		OrdermasterMapper ordermasterMapper=s.getOrdermasterMapper();
		int cnt=ordermasterMapper.selectCount(s.count()+" ordermaster ");
		//System.out.println(ProductNo);
		List<Customer> customer;


			customer=q.selectCustomerNo();
			Gson gson=new Gson();
			TableData obj=new TableData();
		
		obj.setCount(cnt);
		obj.setData(customer);
		System.out.println(gson.toJson(obj));
		return gson.toJson(obj);
	}
	
	@Override
	public void OrdermasterAdd(Ordermaster ordermaster) {
		System.out.println(ordermaster.getCustomerno());
		
		q.insertOrdermaster(ordermaster);
		// TODO Auto-generated method stub
		
	}


	
	@Override
	public void OrdermasterDelete(int OrderNo) {
		// TODO Auto-generated method stub
		q.updateOrdermasterdelect(OrderNo);
	}
	@Override
	public int OrdermasterNo() {
		int Ordermasterno=q.selectOrdermasterno();
		// TODO Auto-generated method stub
		return Ordermasterno;
	}
	
	public void Ordermastersum(double ordermastersum,int ordermasterno)
	{
		q.updateOrdermastersum(ordermastersum, ordermasterno);
	}
}
