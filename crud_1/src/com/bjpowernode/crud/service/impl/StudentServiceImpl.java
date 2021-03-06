package com.bjpowernode.crud.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bjpowernode.crud.dao.StudentDao;
import com.bjpowernode.crud.dao.impl.StudentDaoImpl;
import com.bjpowernode.crud.domain.Students;
import com.bjpowernode.crud.service.StudentService;
import com.bjpowernode.crud.util.Jutil;
import com.bjpowernode.crud.util.PageUtil;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentdao = new StudentDaoImpl();
	@Override
	public Map<String,Object> getAll(String pageNuStr) {
		//每页显示的数量
		int pageCount=5;
		//当前页
		int pageNu =1;
		if(pageNuStr != null && !"".equals(pageNuStr.trim())){
			pageNu = Integer.valueOf(pageNuStr);
		}
		//数据库中有多少条记录
		int  total= studentdao.getNumber();
		//页数
		int pageSize = total/pageCount;
		if(total%pageCount > 0){
			pageSize++;
		}
		if(pageNu == pageSize){
			pageCount = total - (pageNu-1)*pageCount;
		}
		PageUtil pu = new PageUtil();
		pu.setPageCount(pageCount);
		pu.setPageNu(pageNu);
		pu.setPageSize(pageSize);
		pu.setTotal(total);
		//略过的信息
		int skipCount =(pageNu-1)*pageCount; 
		
		List<Students> sList = studentdao.getAll(skipCount,pageCount);
		
		Map<String, Object> map = new HashMap<>();
		map.put("slist", sList);
		map.put("pu", pu);
		return map;
	}
	@Override
	public void addStudent(Students stu) {
		studentdao.addStudent(stu);
		
	}
	@Override
	public Students getStudentById(String id) {
		Students students = studentdao.getStudentById(id);
		return students;
	}
	@Override
	public void updateStudent(Students stu) {
		studentdao.updateStudent(stu);
		
	}
	@Override
	public void deleteStudent(String id) {
		studentdao.deleteStudent(id);
		
	}

}
