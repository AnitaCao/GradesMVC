package com.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mvc.domain.Course;

public class CourseDAOImpl extends AbstractDAO<Integer, Course> implements CourseDAO{
	
	private final Logger logger = LoggerFactory.getLogger(CourseDAOImpl.class);
	
	@Override
	public void addCourse(Course c) {
		persist(c);
		logger.info("Course saved successfully, Course Details="+c);
		
	}

	@Override
	public void updateCourse(Course c) {
		update(c);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Course> listCourses() {
		Criteria criteria = createEntityCriteria();
        return (List<Course>) criteria.list();
	}

	@Override
	public Course getCourseById(int id) {
		return getByKey(id);
	}

	@Override
	public void removeCourse(int id) {
		Course c = getByKey(id);
		if(null != c){
			delete(c);
		}
		logger.info("Course deleted successfully, Course details="+c);
		
	}
 
 
    public Course findCourseByTitle(String title) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("title", title));
        return (Course) criteria.uniqueResult();
    }
    
    public Course findCourseByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (Course) criteria.uniqueResult();
    }
	
	
	
	
}