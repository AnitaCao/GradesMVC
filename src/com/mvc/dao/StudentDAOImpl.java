package com.mvc.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mvc.domain.Student;

public class StudentDAOImpl extends AbstractDAO<Integer, Student> implements StudentDAO {
	
	private final Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

	@Override
	public void addStudent(Student p) {
		persist(p);
		logger.info("Person saved successfully, Person Details="+p);
		
	}

	@Override
	public void updateStudent(Student p) {
		update(p);
		logger.info("Person updated successfully, Person Details="+p);
		
	}

	@Override
	public List<Student> listStudents() {
		
		Criteria criteria = createEntityCriteria();
         @SuppressWarnings("unchecked")
		List<Student> studentsList = (List<Student>) criteria.list();
         for(Student p : studentsList){
 			logger.info("Person List::"+p);
 		}
         return studentsList;
		 
	}

	@Override
	public Student getStudentById(int id) {
		Student s = getByKey(id);
		logger.info("Person loaded successfully, Person details="+s);
		return s;
	}

	@Override
	public void removeStudent(int id) {
		Student s = getByKey(id);
		if(null != s){
			delete(s);
		}
		logger.info("Person deleted successfully, person details="+s);
		
	}
	
	
	
	
}

