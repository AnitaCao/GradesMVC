package com.mvc.dao;

import java.util.List;

import com.mvc.domain.Teacher;

public interface TeacherDAO {

	public void addTeacher(Teacher t);
	public void updateTeacher(Teacher t);
	public List<Teacher> listTeachers();
	public Teacher getTeacherById(int id);
	public void removeTeacher(int id);
	public Teacher findTeacherByName(String tname);
}