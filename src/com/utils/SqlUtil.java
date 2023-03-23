package com.utils;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.bean.Customer;
import com.bean.Orderdetail;
import com.bean.Ordermaster;
import com.bean.Product;
import com.dao.CustomerMapper;
import com.dao.EChartsMapper;
import com.dao.EmployeeMapper;
import com.dao.LogMapper;
import com.dao.Mapper;
import com.dao.OrderdetailMapper;
import com.dao.OrdermasterMapper;
import com.dao.ProductMapper;
import com.dao.UserMapper;
import com.service.dao.EchartsDao;
import com.test.test;



public class SqlUtil {
	public SqlSession session;
    public SqlUtil() {
    	this.beforeLoadXML();
    	
	}
    
    public void beforeLoadXML(){
        //加载 mybatis 配置文件
        InputStream inputStream = test.class.
                getClassLoader().getResourceAsStream("mybatis-configuration.xml");
        //构建sqlSession的工厂
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        //根据 sqlSessionFactory 产生 session
        session = sqlSessionFactory.openSession(true);
        
    }
    
    
    
 	public static String all() {
 		return "select * from ";
 		
 	}
 	
 	public static String count() {
 		return "select count(*) from ";
 	}
 	
 	public static String limit(int page,int limit)
 	{
 		
 		String s=" limit "+(page-1)*limit+","+limit+" ";
 		
 		return s;
 	}
 	
 	public static String whereExist()
 	{
 		return " where state=1 ";
 		
 	}
    
    public Mapper getMapper(){
 	    return session.getMapper(Mapper.class);
 	}
    
 	public EChartsMapper getEChartsMapper()
 	{
 		return session.getMapper(EChartsMapper.class);
 	}
 	
    public EmployeeMapper getEmployeeMapper()
    {
    	return session.getMapper(EmployeeMapper.class);
    }
    
    public CustomerMapper getCustomerMapper()
    {
    	return session.getMapper(CustomerMapper.class);
    }
    
    public LogMapper getLogMapper()
    {
    	return session.getMapper(LogMapper.class);
    }
    
    public OrderdetailMapper getOrderdetailMapper()
    {
    	return session.getMapper(OrderdetailMapper.class);
    }
    
    public OrdermasterMapper getOrdermasterMapper()
    {
    	return session.getMapper(OrdermasterMapper.class);
    }
    
    public ProductMapper getProductMapper()
    {
    	return session.getMapper(ProductMapper.class);
    }
    
    public UserMapper getUserMapper()
    {
    	return session.getMapper(UserMapper.class);
    }
 	
 	public static String quire(Map<String, Object> map) {
		StringBuffer stringBuffer=new StringBuffer(" where state=1 ");
		for(String column:map.keySet()) {
			if(column.equals("customerno")||column.equals("productno")||column.equals("orderno")) {
				stringBuffer.append(" and "+column+"="+map.get(column)+" ");
			}
			else {
				stringBuffer.append(" and "+column+" like '%"+map.get(column)+"%' ");
			}
		}
		String str=stringBuffer.toString();
		return str;
	}
	
}
