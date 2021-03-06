package com.mvc.service;

import java.util.List;

import com.mvc.domain.Course;

public interface CourseService {

	public void addCourse(Course c);
	public void updateCourse(Course c);
	public List<Course> listCourses();
	public Course getCourseById(int id);
	public void removeCourse(int id);
	public boolean isCourseCodeUnique(Integer id, String code);
	public Course findCourseByCode(String code);
}