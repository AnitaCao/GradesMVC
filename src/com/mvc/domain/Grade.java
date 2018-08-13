package com.mvc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mvc.domain.Student;

@Entity
@Table(name = "Grade")
public class Grade {
	
	@Column(name = "id")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@JoinColumn(name = "cid")
	@ManyToOne
	private Course course;
	
	@JoinColumn(name = "sid")
	@ManyToOne
	private Student student;
	
	@Column(name = "grade")
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
