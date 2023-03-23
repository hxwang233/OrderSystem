package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.dao.Mapper;
import com.google.gson.Gson;
import com.utils.Pagination;
import com.utils.SqlUtil;
import com.utils.TableData;

/**
 * Servlet implementation class ShowCustomers
 */
@WebServlet("/ShowCustomers")
public class ShowCustomers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCustomers() {
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
		int page=Integer.parseInt(request.getParameter("page"));
		int limit=Integer.parseInt(request.getParameter("limit"));
		
		String customername=request.getParameter("customername");
		String telephone=request.getParameter("telephone");
		String address=request.getParameter("address");
		String zip=request.getParameter("zip");
		String cno=request.getParameter("customerno");

		Map<String, Object> map=new HashMap<>();
		if(!(customername==null)&&!customername.equals("")) {
			map.put("customername", customername);
		}
		if(!(telephone==null)&&!telephone.equals("")) {
			map.put("telephone", telephone);
		}
		if(!(address==null)&&!address.equals("")) {
			map.put("address", address);
		}
		if(!(zip==null)&&!zip.equals("")) {
			map.put("zip", zip);
		}
		if(!(cno==null)&&!cno.equals("")) {
			int customerno=Integer.parseInt(cno);
			map.put("customerno", customerno);
		}
		System.out.println(map);
		Mapper Mapper=new SqlUtil().getMapper();
		Pagination p=new Pagination(page, limit,"customer", Mapper);
		String res=null;
		if(!map.isEmpty()) {
			res=p.initList(map);
		}
		else{
			res=p.initList();
		}
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
