package com.mvc.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.domain.Student;
import com.mvc.service.StudentService;

@Controller

public class StudentFormController {

	private StudentService studentService; // 注入 service 层

	@Autowired(required = true)
	@Qualifier(value = "studentService")
	public void setPersonService(StudentService ss) {
		this.studentService = ss;
	}

	@RequestMapping(value = "/student/all", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student_list";
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public ModelAndView showForm() {
		System.out.println("here");
		return new ModelAndView("add_student_form", "student", new Student());
	 }
	
	 @RequestMapping(value = "/student/confirmAddStudent", method =
	 RequestMethod.POST)
	 public String submit(@ModelAttribute("student")Student student, 
			 BindingResult result, ModelMap model, HttpSession session) {
		 if (result.hasErrors()) {
			 	System.out.println(result.getAllErrors().get(0));
			 	return "error";
		 }
		 session.setAttribute("studentInfo", student);
		 model.addAttribute("sname", student.getSname());
		 model.addAttribute("ssex", student.getSsex());
		 model.addAttribute("sdob", student.getSdob());
		 model.addAttribute("id", student.getId());
		 return "student_view";
	}
	 
	@RequestMapping(value = "/student/updateStudentList")
	public String updateStudentList(HttpSession session) {
		Student student = (Student) session.getAttribute("studentInfo");
		System.out.println(student.toString());
		this.studentService.addStudent(student); // 调用 Service 层方法，插入数据
		return "redirect:/student/all.action"; // 转向人员列表 action
	}
	 
	// For add and update person both
//	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
//	public String addPerson(@ModelAttribute("student") Student p) {
//
//		if (p.getId() == 0) {
//			// new person, add it
//			this.studentService.addStudent(p);
//		} else {
//			// existing person, call update
//			this.studentService.updateStudent(p);;
//		}
//
//		return "redirect:/student/all";
//
//	}

	@RequestMapping("/student/remove/{id}")
	public String removeStudent(@PathVariable("id") int id) {
		System.out.println("calling remove method.");
		this.studentService.removeStudent(id);
		return "redirect:/student/all.action";
	}

	@RequestMapping("/student/edit/{id}")
	public String editStudent(@PathVariable("id") int id, Model model) {
		model.addAttribute("student", this.studentService.getStudentById(id));
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student_list";
	} 

}