package com.mvc.domain;

import java.util.HashSet;
import java.util.Set;

public class Course {


	private int id;
	
	private String content;
	
	private String title;

	
	
    private Set<Student> students = new HashSet<Student>();
	
	private Teacher teacher;
	
	private Set<Grade> grades = new HashSet<Grade>();
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	

	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	
}
