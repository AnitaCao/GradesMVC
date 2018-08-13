package com.mvc.service;

import java.util.List;

import com.mvc.domain.Teacher;

public interface TeacherService {

	public void addTeacher(Teacher t);
	public void updateTeacher(Teacher t);
	public List<Teacher> listTeachers();
	public Teacher getTeacherById(int id);
	public void removeTeacher(int id);
	public Teacher findTeacherByName(String name);
}