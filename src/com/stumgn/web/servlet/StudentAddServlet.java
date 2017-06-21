package com.stumgn.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.stumgn.bean.Student;
import com.stumgn.service.StudentService;
/**
 * 
 * @author company
 * @date 2017-06-20
 */
public class StudentAddServlet extends HttpServlet{
	private static final long serialVersionUID = 8607577294315007033L;
	private StudentService studentService = new StudentService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = new Student(null, req.getParameter("name"), Byte.parseByte(req.getParameter("sex")));
		boolean flag = studentService.add(student);
		JSONObject jsonObject = new JSONObject();
		if (flag) {
			jsonObject.put("code",200);
		}else{
			jsonObject.put("code", 400);
		}
		resp.getWriter().println(jsonObject.toJSONString());
	}
	
}
