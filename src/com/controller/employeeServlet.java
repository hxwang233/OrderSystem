package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.EmployeeManagerImpl;
import com.utils.SqlUtil;

/**
 * Servlet implementation class employeeServlet
 */
@WebServlet("/employeeServlet")
public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("doget  ");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eno=request.getParameter("employeeno");
		String st=request.getParameter("stime");
		String et=request.getParameter("etime");
		//int limit=Integer.parseInt(request.getParameter("limit"));
		EmployeeManagerImpl e=new EmployeeManagerImpl();
		String sql=" where state=1 ";
		//int flag=0;
		if(eno!=null&&(!eno.equals("")))
		{
			sql+=(" and employeeno="+eno+" ");
		}
		if(st!=null&&(!st.equals("")))
		{
				sql+=(" and hiredate>='"+st+"' ");
		}
		if(et!=null&&(!et.equals("")))
		{

				sql+=(" and hiredate<='"+et+"' ");

		}
		
		System.out.println(sql);
		String res=e.getEmployee(sql);
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(res);
	}

}
