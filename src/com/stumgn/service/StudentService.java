package com.stumgn.service;

import java.util.List;

import com.stumgn.bean.Student;
import com.stumgn.dao.StudentDao;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	
	public List<Student> getAll() {
		return studentDao.findAll();
	}

	public boolean delete(int id) {
		return studentDao.delete(id);
	}

	public boolean add(Student student) {
		return studentDao.save(student);
	}

	public Student getStudent(Integer id) {
		return studentDao.findOne(id);
	}

	public boolean update(Student student) {
		return studentDao.update(student);
	}

}
