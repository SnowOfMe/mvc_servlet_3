package com.bjpowernode.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("servlet2");
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies!=null && cookies.length>0){
			
			for(Cookie cookie:cookies){
				
				System.out.println(cookie.getName());
				System.out.println(cookie.getValue());
				System.out.println("------------------------");
				
			}
			
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}



















