package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.impl.ProductManagerImpl;

/**
 * Servlet implementation class showproductServlet
 */
@WebServlet("/showproductServlet")
public class showproductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public showproductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		String productno = request.getParameter("productno");
		String productname = request.getParameter("productname");
		String productclass = request.getParameter("productclass");
		String pro_createdate = request.getParameter("pro_createdate");
		StringBuilder condition = new StringBuilder();
		if(productno!=null && !productno.equals("")) {
			condition.append(" and ProductNo="+productno+" ");
		}
		if(productname!=null && !productname.equals("")) {
			condition.append(" and productName like '%"+productname+"%' ");
		}
		if(productclass!=null && !productclass.equals("")) {
			condition.append(" and ProductClass like '%"+productclass+"%' ");
		}
		if(pro_createdate!=null && !pro_createdate.equals("")) {
			condition.append(" and Createdate like '%"+pro_createdate+"%' ");
		}
		ProductManagerImpl e = new ProductManagerImpl();

		String res = e.initProduct(page, limit,condition.toString());
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
