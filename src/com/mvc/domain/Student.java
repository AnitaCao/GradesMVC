package com.mvc.domain;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name="Student")
@Entity
@NamedQueries({
	@NamedQuery(name= "student.findAll", query= "select s From Student s"),
	@NamedQuery(name= "student.findByName", query= "select s From Student s where s.sname =:sname"),
})
public class Student {
	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Id
	private int id;
	
	@Column(name="sname")
	private String sname;
	
	@Column(name="ssex")
	private String ssex;
	
	@Column(name="sdob")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date sdob;
	
	public Student() {}  
	  
	public Student(String sname, String ssex,Date sdob ) {  
	    super();     
	    this.sname = sname;  
	    this.ssex = ssex;  
	    this.sdob = sdob;  
	}
	
	@ManyToMany(mappedBy="students")
    private Set<Course> courses = new HashSet<Course>();
	
    @JoinColumn(name = "sid")
	@OneToMany
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
	
		
//	public Set<Course> getCourses() {
//		return courses;
//	}
//	public void setCourses(Set<Course> courses) {
//		this.courses = courses;
//	}
//	public Set<Grade> getGrades() {
//		return grades;
//	}
//	public void setGrades(Set<Grade> grades) {
//		this.grades = grades;
//	}
	public String toString(){
		return "Student Name: " + this.sname + "; DOB: " + this.sdob + "; Sex: " + this.ssex + ".";
		//return "Student id: " + this.id + "; Name: " + this.sname + "; DOB: " + this.sdob + "; Sex: " + this.ssex + ".";
	}
}
