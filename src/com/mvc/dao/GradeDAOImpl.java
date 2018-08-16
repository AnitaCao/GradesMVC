package com.mvc.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.mvc.domain.Grade;
@Repository("gradeDao")
public class GradeDAOImpl extends AbstractDAO<Integer, Grade> implements GradeDAO{
	
	private final Logger logger = LoggerFactory.getLogger(GradeDAOImpl.class);


	@Override
	public void addGrade(Grade g) {
		persist(g);
		logger.info("Grade saved successfully, Grade Details="+g);		
	}

	@Override
	public void updateGrade(Grade g) {
		update(g);
		
	}

	@Override
	public List<Grade> listGrades() {
		return null;
//		Criteria criteria = createEntityCriteria();
//        return (List<Grade>) criteria.list();
	}

	@Override
	public Grade getGradeById(int id) {
		return getByKey(id);
	}

	@Override
	public void removeGrade(int id) {
		Grade g = getByKey(id);
		if(null != g){
			delete(g);
		}
		logger.info("Grade deleted successfully, Grade details="+g);		
	}
	
	
	
	
}

