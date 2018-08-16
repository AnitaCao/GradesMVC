package com.mvc.dao;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mvc.domain.Course;

@Repository("courseDao")
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
		List<Course> coursesList = this.getEntityManager().createQuery("SELECT c FROM Course c").getResultList();
		
        for(Course p : coursesList){
 			logger.info("Course List::"+p);
 		}
         return coursesList;
	}

	@Override
	public Course getCourseById(int id) {
		Course c = getByKey(id);
		if(c!=null) initializeCollection(c.getStudents());
		return c;
	}

	@Override
	public void removeCourse(int id) {
		Course c = getByKey(id);
		if(null != c){
			delete(c);
		}
		logger.info("Course deleted successfully, Course details="+c);
		
	}
 
    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
 
    public Course findCourseByTitle(String title) {
    	return null;
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("title", title));
//        return (Course) criteria.uniqueResult();
    }
    
    public Course findCourseByCode(String code) {
        return null;
    }
	
	
	
	
}