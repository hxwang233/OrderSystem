package com.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.eclipse.jdt.internal.compiler.lookup.ImplicitNullAnnotationVerifier;

import com.bean.Orderdetail;
import com.dao.OrderdetailMapper;
import com.dao.OrdermasterMapper;
import com.google.gson.Gson;
import com.service.dao.OrderdetailDao;
import com.utils.SqlUtil;
import com.utils.TableData;

public class OrderdetailImpl implements OrderdetailDao{
	SqlSession session;
	SqlUtil s;
	OrderdetailMapper q;
	public OrderdetailImpl() {
		s=new SqlUtil();
		session=s.session;
		q=session.getMapper(OrderdetailMapper.class);
	}
	
	@Override
	public void OrderdetailAdd(List<Orderdetail> orderdetail) {
		// TODO Auto-generated method stub
		
		for( int i = 0 ; i < orderdetail.size() ; i++) 
		{//�ڲ���������Ч����ߣ����ڶ��߳�Ҫ���ǲ������������⡣
			System.out.println("����");
			q.insertOrderdetailIn(orderdetail.get(i));
		}
	}
	@Override
	public String OrderdetailSearch(int OrderNo) {
		// TODO Auto-generated method stub
		OrdermasterMapper ordermasterMapper=s.getOrdermasterMapper();
		List<Orderdetail> w1=q.selectOrderdetailON(OrderNo);
		Gson gson=new Gson();
		System.out.println(gson.toJson(w1)+"�༭");
		return gson.toJson(w1);
	}

	@Override
	public void OrderdetailAlter(List<Orderdetail> orderdetail) {
		// TODO Auto-generated method stub
		int orderno=-1;
		for( int i = 0 ; i < orderdetail.size() ; i++) 
		{//�ڲ���������Ч����ߣ����ڶ��߳�Ҫ���ǲ������������⡣
		  q.updateOrderdetailup(orderdetail.get(i)); 
		  orderno=orderdetail.get(i).getOrderno();
		}		
		q.updateOrdersum(orderno);
	
	}

	@Override
	public void OrderdetailDelete() {
		// TODO Auto-generated method stub
		
	}//�޹���

	
}
