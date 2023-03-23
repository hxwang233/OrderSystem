package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import com.dao.CustomerMapper;
import com.utils.SqlUtil;

/**
 * Servlet implementation class CustomerManager
 */
@WebServlet("/CustomerManager")
public class CustomerManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String method=request.getParameter("method");
		System.out.println(method);
		if(method.equals("delete")) {
			deleteCustomer(request,response);
		}
		else if(method.equals("update")) {
			updateCustomer(request,response);
		}
		else if(method.equals("insert")) {
			insertCustomer(request,response);
		}
	}

	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) {
		//int uid =request.getSession().getAttribute("id");
		CustomerMapper customerMapper=new SqlUtil().getCustomerMapper();
		String cname=request.getParameter("title");
		String address=request.getParameter("address");
		String tel=request.getParameter("telephone");
		String zip=request.getParameter("zip");	
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("cname", cname);
		params.put("address", address);
		params.put("telephone", tel);
		params.put("zip", zip);
		params.put("operatorId", 0);
		//params.put("operatorId", uid);
		customerMapper.insert(params);
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
		CustomerMapper customerMapper=new SqlUtil().getCustomerMapper();
		int cno=Integer.parseInt(request.getParameter("customerno"));
		String cname=request.getParameter("customername");
		String newaddress=request.getParameter("address");
		String tel=request.getParameter("telephone");
		String newzip=request.getParameter("zip");		
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("cno", cno);
		params.put("cname", cname);
		params.put("newaddress", newaddress);
		params.put("tel", tel);
		params.put("newzip", newzip);
		params.put("operatorId", 0);
		System.out.println(params);
		customerMapper.update(params);
	}

	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
		CustomerMapper customerMapper=new SqlUtil().getCustomerMapper();
		int cno=Integer.parseInt(request.getParameter("customerno"));
		Map<String,Object> params=new HashMap<String, Object>();
		params.put("cno", cno);
		params.put("operatorId", 0);
		customerMapper.delete(params);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
