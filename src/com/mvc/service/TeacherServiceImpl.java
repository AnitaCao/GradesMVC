package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.TeacherDAO;
import com.mvc.domain.Teacher;

@Service("teacherService")
@Transactional
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherDAO teacherDAO;

	@Override
	public void addTeacher(Teacher t) {
		this.teacherDAO.addTeacher(t);;
	}

	@Override
	public void updateTeacher(Teacher t) {
		this.teacherDAO.updateTeacher(t);;
	}

	@Override
	public List<Teacher> listTeachers() {
		return this.teacherDAO.listTeachers();
	}

	@Override
	public Teacher getTeacherById(int id) {
		return this.teacherDAO.getTeacherById(id);
	}

	@Override
	public void removeTeacher(int id) {
		this.teacherDAO.removeTeacher(id);
	}


	public Teacher findTeacherByName(String name) {
		return this.teacherDAO.findTeacherByName(name);
	}

}