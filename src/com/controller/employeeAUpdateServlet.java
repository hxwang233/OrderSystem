package com.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeMapper;
import com.utils.SqlUtil;


@WebServlet("/employeeAUpdateServlet")
public class employeeAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public employeeAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EmployeeMapper employeeMapper=new SqlUtil().getEmployeeMapper();
		int eno=Integer.parseInt(request.getParameter("employeeno"));
		String Newdepartment = request.getParameter("department");
		String Newheadship = request.getParameter("headship");
		double Newsalary=Double.parseDouble(request.getParameter("salary"));
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("eno", eno);
		params.put("Newdepartment", Newdepartment);
		params.put("Newheadship", Newheadship);
		params.put("Newsalary", Newsalary);
		params.put("operatorID", 0);
		System.out.println(params);
	    employeeMapper.AUpdate(params);
	}

}
