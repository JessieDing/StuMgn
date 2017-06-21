package com.stumgn.web.servlet;

import java.io.IOException;
import java.util.List;

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
public class StudentSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 8607577294315007033L;
	private StudentService studentService = new StudentService();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchPattern = req.getParameter("searchPattern");
		String searchValue = req.getParameter("searchValue");
		JSONObject jsonObject = new JSONObject();
		if (searchPattern != null) {
			List<Student> studentList = null;
			if ("name".equals(searchPattern)) {
				studentList = studentService.getByName(searchValue);
			} else if ("sex".equals(searchPattern)) {
				studentList = studentService.getBySex((byte) ("男".equals(searchValue) ? 1 : 0));
			}
			if (studentList != null) {
				jsonObject.put("code", 200);// 200表示查询到了需要的数据
				jsonObject.put("data", studentList);
			} else {
				jsonObject.put("code", 300);// 300表示查询失败！没有数据！
			}
		} else {
			jsonObject.put("code", 301);// 301表示没有获取到查询方式参数
		}
		resp.getWriter().print(jsonObject.toJSONString());
	}

}
