package com.service.dao;

public interface ProductManagerDao {
	 String initProduct(int page,int limit,String condition);
	 String judgeproduct(String condition);

}
