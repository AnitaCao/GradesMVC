package com.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.CourseDAO;
import com.mvc.domain.Course;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	private CourseDAO courseDAO;

	public void setCourseDAO(CourseDAO cd) {
		this.courseDAO = cd;

	}

	@Override
	public void addCourse(Course c) {
		this.courseDAO.addCourse(c);
	}

	@Override
	public void updateCourse(Course c) {
		this.courseDAO.updateCourse(c);
	}

	@Override
	public List<Course> listCourses() {
		return this.courseDAO.listCourses();
	}

	@Override
	public Course getCourseById(int id) {
		return this.courseDAO.getCourseById(id);
	}

	@Override
	public void removeCourse(int id) {
		this.courseDAO.removeCourse(id);
	}

	public boolean isCourseCodeUnique(Integer id, String code) {
		Course c = findCourseByCode(code);
		return (c == null || ((id != null) && (c.getId() == id)));
	}

	public Course findCourseByCode(String code) {
		return this.courseDAO.findCourseByCode(code);
	}

}