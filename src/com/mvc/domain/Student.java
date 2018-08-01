package com.mvc.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;


public class Student {
	private int id;
	
	private String sname;
	
	private String ssex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sdob;
	
	public Student() {}  
	  
	public Student(String sname, String ssex,Date sdob ) {  
	    super();     
	    this.sname = sname;  
	    this.ssex = ssex;  
	    this.sdob = sdob;  
	}
	
    private Set<Course> courses = new HashSet<Course>();
	
    private Set<Grade> grades = new HashSet<Grade>();
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	
	public Date getSdob() {
		return sdob;
	}
	public void setSdob(Date sdob) {
		this.sdob = sdob;
	}
	
		
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	public String toString(){
		return "Student Name: " + this.sname + "; DOB: " + this.sdob + "; Sex: " + this.ssex + ".";
		//return "Student id: " + this.id + "; Name: " + this.sname + "; DOB: " + this.sdob + "; Sex: " + this.ssex + ".";
	}
}
