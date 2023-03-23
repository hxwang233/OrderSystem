package com.controller;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Employee;
import com.bean.Orderdetail;
import com.bean.Ordermaster;
import com.service.impl.OrderdetailImpl;
import com.service.impl.OrdermasterImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * Servlet implementation class OrdermasterServlet
 */
@WebServlet("/OrdermasterAddServlet")
public class OrdermasterAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdermasterAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		 // ��ȡsession
		HttpSession session = request.getSession();
		 double sum=0;
		 String customerNo=request.getParameter("customerno").toString();
		 Employee employee=(Employee)request.getSession().getAttribute("employee");
		 Integer  saleso=2006001;//employee.getEmployeeno();//获得员工号。需要登录得到
		 
		 String SaleNo=saleso.toString();
		 
		 OrdermasterImpl ordermasterimpl=new OrdermasterImpl();
		 OrderdetailImpl orderdetailimpl= new OrderdetailImpl();
		 
		Ordermaster w=new Ordermaster();
		
		String Invoiceno=String.valueOf((int)(1+Math.random()*(10000-1+1)));
				System.out.println(Invoiceno);
		w.setCustomerno(customerNo);
		w.setSaleno(SaleNo);
		w.setOrderdate(new Date());
		w.setShipdate(new Date());
		w.setInvoiceno(Invoiceno);
		ordermasterimpl.OrdermasterAdd(w);
		
		
		int Ordermasterno=ordermasterimpl.OrdermasterNo();
		System.out.println(Ordermasterno);
		 String ds = request.getParameter("productno");//productno�Ǵ����orderdetail��ϸ
		 String[] numberArray=ds.split("\\,");
		/* for(int i=0;i<numberArray.length;i++)
		 System.out.println(numberArray[i]);*/
		 
		 List<Orderdetail> orderdetail_temp = new ArrayList<>();
		 for(int i=0;i<numberArray.length-1;i++)
		 {
			 Orderdetail temp=new Orderdetail();

				 temp.setOrderno(Ordermasterno);
				 temp.setProductno(numberArray[i]);
				 temp.setPrice(ordermasterimpl.getProductPrice(numberArray[i]));
				 temp.setQty(Integer.parseInt(numberArray[i+1]));
				 sum+=ordermasterimpl.getProductPrice(numberArray[i])*Integer.parseInt(numberArray[i+1]);
				 i++;
				 orderdetail_temp.add(temp);
		 }
		 
		 for(int i=0;i<numberArray.length/2;i++)
		 { 
			 System.out.println("______________");
			 System.out.println(orderdetail_temp.get(i).getOrderno());
			 System.out.println(orderdetail_temp.get(i).getProductno());
			 System.out.println(orderdetail_temp.get(i).getQty());
		 }
		 
		 ordermasterimpl.Ordermastersum(sum, Ordermasterno);
		 orderdetailimpl.OrderdetailAdd(orderdetail_temp);
		 
		 
		System.out.println("ceshi111");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

    // Map --> Bean 1: ����Introspector,PropertyDescriptorʵ�� Map --> Bean 

    public static void transMap2Bean(Map<String, Object> map, Object obj) { 
        try { 
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass()); 
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors(); 
            for (PropertyDescriptor property : propertyDescriptors) { 
                String key = property.getName(); 
                if (map.containsKey(key)) { 
                    Object value = map.get(key); 
                    // �õ�property��Ӧ��setter���� 
                    Method setter = property.getWriteMethod(); 
                    setter.invoke(obj, value); 
                } 
            } 
        } catch (Exception e) { 
            System.out.println("transMap2Bean Error " + e); 
        } 
        return; 
    } 
}
