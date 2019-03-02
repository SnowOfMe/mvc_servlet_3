package com.bjpowernode.homework.demo2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bjpowernode.common.util.Jutilcom;

public class Register extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name =request.getParameter("username");
		String password =request.getParameter("password");
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = Jutilcom.getConnection();
			String sql = "insert into tbl_user(username,password) value (?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2,password );
			int i = ps.executeUpdate();
			System.out.println("更新了"+i +"条数据");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Jutilcom.close2(conn, ps, null);
		}
		response.sendRedirect("/servlet_1_practice/login.html");
	}

}