package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeMapper;
import com.dao.UserMapper;
import com.utils.SqlUtil;


@WebServlet("/employeeDeleteServlet")
public class employeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public employeeDeleteServlet() {
        super();
        
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int EmployeeNo =Integer.parseInt(request.getParameter("employeeno"));
		EmployeeMapper employeeMapper=new SqlUtil().getEmployeeMapper();
		
		employeeMapper.deleteE(EmployeeNo);	
		UserMapper userMapper=new SqlUtil().getUserMapper();
		userMapper.deleteU(EmployeeNo);
		response.getWriter().write("delete ok");
	}
}
