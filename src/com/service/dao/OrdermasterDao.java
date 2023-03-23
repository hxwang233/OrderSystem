package com.service.dao;

import java.util.Date;
import java.util.List;

import com.bean.Ordermaster;

public interface OrdermasterDao {

	public void OrdermasterAdd(Ordermaster ordermaster);

	public int OrdermasterNo();
	public void Ordermastersum(double ordermastersum,int ordermasterno);
	public void OrdermasterDelete(int OrderNo);
}
