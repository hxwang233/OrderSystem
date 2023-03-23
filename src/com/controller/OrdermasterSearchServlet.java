package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrdermasterMapper;
import com.service.impl.OrdermasterImpl;

/**
 * Servlet implementation class OrdermasterSearchServlet
 */
@WebServlet("/OrdermasterSearchServlet")
public class OrdermasterSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdermasterSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int page = Integer.parseInt(request.getParameter("page"));
		int limit = Integer.parseInt(request.getParameter("limit"));
		String orderno =request.getParameter("orderno");
		String customerno = request.getParameter("customerno");
		String invoiceno = request.getParameter("invoiceno");
		String order_createdate = request.getParameter("order_createdate");
		StringBuilder condition = new StringBuilder();
		if(orderno!=null && !orderno.equals("")) {
			condition.append(" and OrderNo="+orderno+" ");
		}
		if(customerno!=null && !customerno.equals("")) {
			condition.append(" and CustomerNo ="+customerno+"");
		}
		if(invoiceno!=null && !invoiceno.equals("")) {
			condition.append(" and InvoiceNo like '%"+invoiceno+"%' ");
		}
		if(order_createdate!=null && !order_createdate.equals("")) {
			condition.append(" and Orderdate like '%"+order_createdate+"%' ");
		}
		OrdermasterImpl  e = new OrdermasterImpl ();

		String res = e.initOrderMaster(page, limit,condition.toString());
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
