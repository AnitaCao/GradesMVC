package com.mvc.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Table(name = "Student")
@Entity
@NamedQueries({ @NamedQuery(name = "student.findAll", query = "select s From Student s"),
		@NamedQuery(name = "student.findByName", query = "select s From Student s where s.first_name =:first_name"), })
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3957870341000682423L;

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name = "first_name")
	private String first_name;

	@NotNull
	@Size(min = 3, max = 50)
	@Column(name = "last_name")
	private String last_name;

	@Column(name = "ssex")
	private String ssex;

	@Column(name = "sdob")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date sdob;

	public Student() {
	}

	public Student(String first_name, String last_name, String ssex, Date sdob) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.ssex = ssex;
		this.sdob = sdob;
	}

	
	@JoinTable(name="Grade",//中间表的名称
    joinColumns={@JoinColumn(name="cid",referencedColumnName="id")},//中间表PRODUCT_ID字段关联PRODUCT的ID
    inverseJoinColumns={@JoinColumn(name="sid",referencedColumnName="id")})//中间表CATEGORY_ID字段关联CATEGORY的ID
    @ManyToMany(fetch = FetchType.LAZY)
	private Set<Course> courses = new HashSet<Course>();
	//
	// @JoinColumn(name = "sid")
	// @OneToMany
	// private Set<Grade> grades = new HashSet<Grade>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String coursesDisplay(){
		StringBuffer sb = new StringBuffer();
		for(Course c: courses){
			sb.append(c.getCode() + " " + c.getTitle() + ";");
		}
		return sb.toString();
	}
	
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	
	public String getSname(){
		return this.first_name + "/" + this.last_name;
	}

	// public Set<Grade> getGrades() {
	// return grades;
	// }
	// public void setGrades(Set<Grade> grades) {
	// this.grades = grades;
	// }
	public String toString() {
		return "Student Name: " + this.getSname() + "; DOB: " + this.sdob + "; Sex: " + this.ssex
				+ ".";
		// return "Student id: " + this.id + "; Name: " + this.sname + "; DOB: "
		// + this.sdob + "; Sex: " + this.ssex + ".";
	}
}
