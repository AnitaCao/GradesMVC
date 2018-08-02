package com.mvc.dao;

import java.util.List;

import com.mvc.domain.Student;

public interface StudentDAO {

	public void addStudent(Student p);
	public void updateStudent(Student p);
	public List<Student> listStudents();
	public Student getStudentById(int id);
	public void removeStudent(int id);
}