package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Employee;
import com.bean.User;
import com.dao.EmployeeMapper;
import com.dao.UserMapper;
import com.service.impl.ManageLoginImpl;
import com.utils.SqlUtil;

/**
 * Servlet implementation class LoginServlet
 * 管理员登陆
 */
@WebServlet("/ManagerLoginServlet")
public class ManagerLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManagerLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int un = Integer.parseInt(request.getParameter("userid"));
		String pw = request.getParameter("password");
		ManageLoginImpl manageLoginImpl = new ManageLoginImpl();
		User admin = manageLoginImpl.loginJudge(un, pw);
		if (admin != null && admin.getPermission()==0) {
			System.out.println("login ManageLogin ok");
			HttpSession session = request.getSession();
			session.setAttribute("id", admin.getUserid());
			UserMapper managerMapper=new SqlUtil().getUserMapper();
			User manager=managerMapper.selectI(admin.getUserid());
			response.sendRedirect("./manager/index.html");
			
		} 
		else {
			System.out.println("login ManageLogin fail");
			response.getWriter().write("fail");
		}

		doGet(request, response);
	}

}
