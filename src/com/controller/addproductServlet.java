package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Select;

import com.bean.Employee;
import com.bean.Product;
import com.dao.ProductMapper;
import com.service.impl.ProductManagerImpl;
import com.utils.SqlUtil;

/**
 * Servlet implementation class productServlet
 */
@WebServlet("/addproductServlet")
public class addproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addproductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productname=request.getParameter("productname");
		String productclass=request.getParameter("productclass");
		double productprice=Double.parseDouble(request.getParameter("productprice"));
		ProductMapper productMapper=new SqlUtil().getProductMapper();
		ProductManagerImpl e = new ProductManagerImpl();
		if(e.judgeproduct(productname)!=null) {
			response.getWriter().write("fail");
		}else {
		Employee employee = (Employee)request.getSession().getAttribute("employee");
	
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("pname", productname);
		params.put("pclass", productclass);
		params.put("price", productprice);
		params.put("operatorId ", employee.getEmployeeno());
		productMapper.insert(params);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
