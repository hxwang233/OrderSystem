package com.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.LogMapper;
import com.google.gson.Gson;
import com.utils.SqlUtil;
import com.utils.TableData;

/**
 * Servlet implementation class test
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*LogMapper logMapper=new SqlUtil().getLogMapper();
		TableData tableData=new TableData();
		tableData.setData(logMapper.selectAll());
		tableData.setCount(logMapper.selectCount());
		Gson gson=new Gson();
		System.out.println(gson.toJson(tableData));
		response.getWriter().write(gson.toJson(tableData));*/
		//response.sendRedirect("./manager/logtable.html");
		//request.getRequestDispatcher("./manager/logtable.html").forward(request,response);
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogMapper logMapper=new SqlUtil().getLogMapper();
		TableData tableData=new TableData();
		tableData.setData(logMapper.selectAll());
		tableData.setCount(logMapper.selectCount());
		Gson gson=new Gson();
		response.setCharacterEncoding("utf-8");
		response.getWriter().write(gson.toJson(tableData));
		//response.sendRedirect("./manager/logtable.html");
		//request.getRequestDispatcher("./manager/logtable.html").forward(request,response);
	}

}
