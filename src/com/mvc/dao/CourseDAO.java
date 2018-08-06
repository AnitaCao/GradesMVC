package com.mvc.dao;

import java.util.List;

import com.mvc.domain.Course;

public interface CourseDAO {

	public void addCourse(Course c);
	public void updateCourse(Course c);
	public List<Course> listCourses();
	public Course getCourseById(int id);
	public void removeCourse(int id);
	public Course findCourseByCode(String code);
}