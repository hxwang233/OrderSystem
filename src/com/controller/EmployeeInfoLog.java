package com.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.LogManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.converters.SqlDateConverter;

import com.bean.Log;
import com.dao.LogMapper;
import com.google.gson.Gson;
import com.utils.SqlUtil;

/**
 * Servlet implementation class EmployeeInfoLog
 */
@WebServlet("/EmployeeInfoLog")
public class EmployeeInfoLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeInfoLog() {
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
		LogMapper logMapper=new SqlUtil().getLogMapper();
		List<Log> logs=logMapper.employeeLog(1);
		Gson gson=new Gson();
		String res=gson.toJson(logs);
		System.out.println(res);
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
