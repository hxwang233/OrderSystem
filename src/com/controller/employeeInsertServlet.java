package com.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.bean.User;
import com.dao.EmployeeMapper;
import com.dao.UserMapper;
import com.google.gson.Gson;
import com.utils.SqlUtil;

@WebServlet("/employeeInsertServlet")
public class employeeInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public employeeInsertServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("insert employee");
		Employee employee=new Employee();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String sex = request.getParameter("sex");
		String EmployeeName = request.getParameter("employeename");
		String Department = request.getParameter("department");
		String Headship = request.getParameter("headship");
		//Date Hiredate =new Date( request.getParameter("hiredate"));
		String d=request.getParameter("birthday");
		
		
		Date Birthday  = java.sql.Date.valueOf(d);

		double Salary =Double.parseDouble(request.getParameter("salary")) ;
		String Address = request.getParameter("address");
		String Telephone = request.getParameter("telephone");
		employee.setAddress(Address);
		employee.setDepartment(Department);
		employee.setEmployeename(EmployeeName);
		employee.setHeadship(Headship);
		employee.setSex(sex);
		employee.setTelephone(Telephone);
		employee.setBirthday(Birthday);
		//employee.setHiredate(Hiredate);
		employee.setSalary(Salary);
		
		EmployeeMapper employeeMapper=new SqlUtil().getEmployeeMapper();
		employeeMapper.insert(employee);
		int EmployeeNo=employee.getEmployeeno();
		//System.out.println("emno"+EmployeeNo);
		UserMapper userMapper=new SqlUtil().getUserMapper();
		User user=new User();
		user.setAccount(""+EmployeeNo);
		user.setUserid(EmployeeNo);
		userMapper.insert(user);
		Gson gson=new Gson();
		response.getWriter().write("ojbk");
		//System.out.println(gson.toJson(employee));
		//System.out.println(gson.toJson(user));
		
	}

}
