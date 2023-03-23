package com.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Orderdetail;
import com.bean.Ordermaster;
import com.dao.OrdermasterMapper;
import com.google.gson.Gson;
import com.service.impl.OrderdetailImpl;
import com.service.impl.OrdermasterImpl;
import com.utils.SqlUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class OrdermasterAlterServlet
 */
@WebServlet("/OrderdetailAlterServlet")
public class OrderdetailAlterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderdetailAlterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html;charset=UTF-8");
		 // ��ȡsession
		 HttpSession session = request.getSession();
		 
			
		int orderno = Integer.parseInt(request.getParameter("orderno"));
		OrderdetailImpl orderdetailimpl=new OrderdetailImpl();
					
		 OrdermasterImpl ordermasterimpl=new OrdermasterImpl();

		
		 String   ds=request.getParameter("orderno");
		 System.out.println(ds+"no");
		 Map<String, String[]> map = request.getParameterMap();
		 String[] productno=map.get("productno");
		 String[] qty=map.get("qty");
		 String[] price=map.get("price");
		 
		 

		 
		 List<Orderdetail> orderdetail_temp = new ArrayList<Orderdetail>();
		 for(int i=0;i<productno.length;i++)
		 {
			 Orderdetail temp=new Orderdetail();
			 temp.setOrderno(orderno);
			 temp.setPrice(Double.parseDouble(price[i]));
			 temp.setProductno(productno[i]);
			 temp.setQty(Integer.parseInt(qty[i]));
			 orderdetail_temp.add(temp);
		 }//��ʼ�������б���ÿһ��ordertail����list��
		 
		 

		 orderdetailimpl.OrderdetailAlter(orderdetail_temp);
		 OrdermasterMapper omap=new SqlUtil().getOrdermasterMapper();
		 String res=new Gson().toJson(omap.selectOrdermaster(orderno));
		 
		 System.out.println("yes");
		 response.getWriter().write(res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	

}
