package com.stumgn.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.stumgn.bean.Student;
import com.stumgn.service.StudentService;

public class StudentDelServlet extends HttpServlet {
	private static final long serialVersionUID = 6955981370047598718L;
	private StudentService studentService = new StudentService();
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		boolean flag = studentService.delete(id);
		JSONObject jsonObject = new JSONObject();
		if(flag){
			jsonObject.put("code", 200);
		}else{
			jsonObject.put("code", 400);
		}
		PrintWriter writer = response.getWriter();
		writer.println(jsonObject.toJSONString());
	}
}
