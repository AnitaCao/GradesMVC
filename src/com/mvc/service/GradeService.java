package com.mvc.service;

import java.util.List;

import com.mvc.domain.Grade;

public interface GradeService {

	public void addGrade(Grade p);
	public void updateStudent(Grade p);
	public List<Grade> listGrades();
	public Grade getGradeById(int id);
	public void removeGrade(int id);
}