package com.mvc.dao;

import java.util.List;

import com.mvc.domain.Grade;

public interface GradeDAO {

	public void addGrade(Grade p);
	public void updateGrade(Grade p);
	public List<Grade> listGrades();
	public Grade getGradeById(int id);
	public void removeGrade(int id);
}