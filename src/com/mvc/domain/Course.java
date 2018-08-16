package com.mvc.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.mvc.domain.Student;

@Table(name="Course")
@Entity
public class Course implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7826419813647868687L;

	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Id
	private int id;
	
	@NotEmpty
	@Column(name="code", unique=true, nullable = false)
	private String code;
	
	@Column(name="content")
	private String content;
	
	@NotNull
	@Size(min=3, max=50)
	@Column(name="title")
	private String title;

//	@JoinTable(name="Grade",//中间表的名称
//            joinColumns={@JoinColumn(name="cid",referencedColumnName="id")},//中间表PRODUCT_ID字段关联PRODUCT的ID
//            inverseJoinColumns={@JoinColumn(name="sid",referencedColumnName="id")})//中间表CATEGORY_ID字段关联CATEGORY的ID
//    @ManyToMany(fetch = FetchType.LAZY)
	@ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<Student>();
	
	@JoinColumn(name = "tid")
	@ManyToOne(fetch = FetchType.LAZY)
	private Teacher teacher;
	
	@JoinColumn(name = "cid")
	@OneToMany
	private Set<Grade> grades = new HashSet<Grade>();
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	

	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Set<Grade> getGrades() {
		return grades;
	}
	public void setGrades(Set<Grade> grades) {
		this.grades = grades;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	
}
