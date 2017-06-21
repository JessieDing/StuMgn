package com.stumgn.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stumgn.bean.Student;

public class StudentDao extends BaseDao {

	public List<Student> findAll() {
		openConnection();
		String sql = "select id,name,sex from tb_student";
		List<Student> studentList = new ArrayList<>();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 包装数据
			while(rs.next()){
				studentList.add(new Student(rs.getInt("id"),rs.getString("name"),rs.getByte("sex")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return studentList;
	}

	public boolean delete(int id) {
		openConnection();
		String sql = "delete from tb_student where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally{
			closeConnection();
		}
	}

	public boolean save(Student student) {
		openConnection();
		String sql = "insert into tb_student(name,sex) values(?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, student.getName());
			pstmt.setObject(2, student.getSex());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection();
		}
	}

	public Student findOne(Integer id) {
		openConnection();
		String sql = "select id,name,sex from tb_student where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()){
				return new Student(rs.getInt("id"),rs.getString("name"),rs.getByte("sex"));
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}
	}

	public boolean update(Student student) {
		openConnection();
		String sql = "update tb_student set name = ?, sex = ? where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, student.getName());
			pstmt.setObject(2, student.getSex());
			pstmt.setObject(3, student.getId());
			return pstmt.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeConnection();
		}
	}

}
