package com.bjpowernode.servlet_3_practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet6 extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		System.out.println("����servlet6");
		ServletContext application = this.getServletContext();
		String value = (String)application.getAttribute("str1");
		PrintWriter out = response.getWriter();
		out.print(value);
		out.close();
//		request.getRequestDispatcher("/WEB-INF/Practice_10.html").forward(request, response);;
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response); 
	}
}
