package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

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
import com.service.impl.CommentLoginImpl;
import com.service.impl.ManageLoginImpl;
import com.utils.SqlUtil;

/**
 * Servlet implementation class CommentLoginServlet
 * 普通用户登陆
 */
@WebServlet("/CommentLoginServlet")
public class CommentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ui = Integer.parseInt(request.getParameter("userid"));
		String pw = request.getParameter("password");
		CommentLoginImpl commentLoginImpl=new CommentLoginImpl();
		User admin = commentLoginImpl.loginJudge(ui, pw);
		if (admin != null && admin.getPermission()==1) {
			System.out.println("login Comment ok");
			HttpSession session = request.getSession();
			session.setAttribute("id", admin.getUserid());
			EmployeeMapper employeeMapper=new SqlUtil().getEmployeeMapper();
			Employee employee=employeeMapper.selectI(admin.getUserid());
			session.setAttribute("employee", employee);
			response.sendRedirect("./employee/index.html");
		} 
		else {
			response.getWriter().write("fail");
		}

		doGet(request, response);
	}

}
