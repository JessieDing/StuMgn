package com.stumgn.bean;

public class Student {
	private Integer	id;
	private String	name;
	private Byte	sex;

	public Student() {
		
	}

	public Student(Integer id, String name, Byte sex) {
		this.id = id;
		this.name = name;
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Byte getSex() {
		return sex;
	}

	public void setSex(Byte sex) {
		this.sex = sex;
	}
}
