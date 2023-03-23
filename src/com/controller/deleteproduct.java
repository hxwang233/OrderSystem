package com.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ProductMapper;
import com.utils.SqlUtil;

/**
 * Servlet implementation class deleteproduct
 */
@WebServlet("/deleteproduct")
public class deleteproduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteproduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productno=Integer.parseInt(request.getParameter("productno"));
		String employeeno = (String)request.getSession().getAttribute("employeeno");
		ProductMapper productMapper=new SqlUtil().getProductMapper();
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("pno", productno);
		params.put("operatorId ", employeeno);
		productMapper.delete(params);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
