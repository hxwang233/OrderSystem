package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Select;

import com.bean.Employee;
import com.dao.EmployeeMapper;
import com.google.gson.Gson;
import com.utils.SqlUtil;

/**
 * Servlet implementation class PersonMessageServlet
 */
@WebServlet("/PersonMessageServlet")
public class PersonMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Employee employee=(Employee)session.getAttribute("employee");
		SqlUtil u=new SqlUtil();
		EmployeeMapper employeeMapper=u.getEmployeeMapper();
		Gson gson=new Gson();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(gson.toJson(employeeMapper.selectMessage(employee.getEmployeeno()))) ;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
