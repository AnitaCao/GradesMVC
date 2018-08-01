package com.mvc.domain;

public class Grade {
	
	private int id;

	private Course course;
	
	private Student student;
	
	private int grade;
	
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String toString(){
		return "Student name: " + this.student.getSname() + "; Course is: " + this.course.getTitle() + "; Grade is : " + this.grade + ".";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	

}
