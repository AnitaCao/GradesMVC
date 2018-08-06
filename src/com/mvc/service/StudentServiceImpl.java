package com.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.StudentDAO;
import com.mvc.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {  // 模拟内存数据库，准备数据

	private StudentDAO studentDAO;
	
	public void setStudentDAO(StudentDAO sd){
		this.studentDAO = sd;
	}
	
	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);
	}
}