package com.stumgn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.stumgn.bean.Student;
import com.stumgn.service.StudentService;

public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 6955981370047598718L;
	private StudentService studentService = new StudentService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> studentList = studentService.getAll();
		//response.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain;charset=utf-8");
		PrintWriter writer = response.getWriter();
		writer.println(JSON.toJSONString(studentList));
	}
}
