package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.classfmt.MethodInfoWithAnnotations;

import com.dao.EmployeeMapper;
import com.utils.SqlUtil;


@WebServlet("/employeeSUpdateServlet")
public class employeeSUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public employeeSUpdateServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmployeeMapper employeeMapper=new SqlUtil().getEmployeeMapper();
		int eno=Integer.parseInt(request.getParameter("employeeno"));
		String day=request.getParameter("birthday");
		String Newaddress = request.getParameter("address");
		String Newtelephone = request.getParameter("telephone");
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("eno",eno);
		params.put("Newbirthday",day);
		params.put("Newaddress",Newaddress);
		params.put("Newtelephone",Newtelephone);
	    System.out.println(params);
	    employeeMapper.SUpdate(params);
	}
}
