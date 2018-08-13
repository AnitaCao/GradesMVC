package com.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mvc.domain.Student;
import com.mvc.domain.Teacher;

@Repository("teacherDao")
public class TeacherDAOImpl extends AbstractDAO<Integer, Teacher> implements TeacherDAO{
	
	private final Logger logger = LoggerFactory.getLogger(TeacherDAOImpl.class);
	
	@Override
	public void addTeacher(Teacher t) {
		persist(t);
		logger.info("Teacher saved successfully, Teacher Details="+t);
		
	}

	@Override
	public void updateTeacher(Teacher t) {
		update(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> listTeachers() {
		 @SuppressWarnings("unchecked")
			List<Teacher> teachersList = this.getEntityManager().createQuery("SELECT t FROM Teacher t ORDER BY t.id ASC").getResultList();
			
	        for(Teacher p : teachersList){
	 			logger.info("Teacher List::"+p);
	 		}
	         return teachersList;
	}

	@Override
	public Teacher getTeacherById(int id) {
		return getByKey(id);
	}

	@Override
	public void removeTeacher(int id) {
		Teacher c = getByKey(id);
		if(null != c){
			delete(c);
		}
		logger.info("Teacher deleted successfully, Teacher details="+c);
		
	}
 
    public Teacher findTeacherByName(String tname) {
//        Criteria criteria = createEntityCriteria();
//        criteria.add(Restrictions.eq("tname", tname));
//        return (Teacher) criteria.uniqueResult();
    	return null;
    }
    

	
	
	
	
}