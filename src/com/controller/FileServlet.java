package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.impl.MySQLDatabaseBackup;
import com.service.impl.MySQLDatabaseRestore;

/**
 * Servlet implementation class FileServlet
 */
@WebServlet("/FileServlet")
public class FileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getParameter("path");
		String fpath = request.getParameter("fpath");
		String fname = request.getParameter("filename");
		if (path == null || path.equals("")) {
			try {
				// if (importDatabaseTool("rm-wz947lnq4xhk7b1f4so.mysql.rds.aliyuncs.com",
				// "root", "123456789Aa", "E:/hahahaha", "test2.sql", "ordermanager")) {
				if (MySQLDatabaseBackup.exportDatabaseTool("127.0.0.1", "root", "123456", "E:/hahahaha", "test2.sql",
						"ordermanager")) {
					System.out.println("Success");
				} else {
					System.out.println("Failure");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		} else {
			try {
				// if (importDatabaseTool("rm-wz947lnq4xhk7b1f4so.mysql.rds.aliyuncs.com",
				// "root", "123456789Aa", "E:/hahahaha", "test2.sql", "ordermanager")) {
				if (MySQLDatabaseRestore.importDatabaseTool("127.0.0.1", "root", "123456", "E:/hahahaha", fname,
						"ordermanager")) {
					System.out.println("Success");
				} else {
					System.out.println("Failure");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
		response.getWriter().write("ojbk");

	}

}
