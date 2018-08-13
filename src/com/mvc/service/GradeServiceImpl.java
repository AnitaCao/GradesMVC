package com.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.GradeDAO;
import com.mvc.domain.Grade;

@Service("gradeService")
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDAO gradeDAO;

	@Override
	public void addGrade(Grade p) {
		this.gradeDAO.addGrade(p);
	}

	@Override
	public void updateStudent(Grade p) {
		this.gradeDAO.updateGrade(p);
	}

	@Override
	public List<Grade> listGrades() {
		return this.gradeDAO.listGrades();
	}

	@Override
	public Grade getGradeById(int id) {
		return this.gradeDAO.getGradeById(id);
	}

	@Override
	public void removeGrade(int id) {
		this.gradeDAO.removeGrade(id);
	}

}