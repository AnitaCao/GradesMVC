package com.mvc.dao;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mvc.domain.Student;

@Repository("studentDao")
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
        @SuppressWarnings("unchecked")
		List<Student> studentsList = this.getEntityManager().createQuery("SELECT s FROM Student s ORDER BY s.id ASC").getResultList();
		
        for(Student p : studentsList){
        	if(p!=null) initializeCollection(p.getCourses());
 			logger.info("Student List::"+p);
 		}
        return studentsList;
		 
	}

	@Override
	public Student getStudentById(int id) {
		Student s = getByKey(id);
		if(s!=null) initializeCollection(s.getCourses());
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
	
    //An alternative to Hibernate.initialize()
    protected void initializeCollection(Collection<?> collection) {
        if(collection == null) {
            return;
        }
        collection.iterator().hasNext();
    }
	
	
}

