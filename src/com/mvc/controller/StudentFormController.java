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

	private StudentService studentService;

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

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.studentService.removeStudent(id);
		return "redirect:/student/all";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.studentService.getStudentById(id));
		model.addAttribute("listPersons", this.studentService.listStudents());
		return "student_list";
	}

	// @Resource
	// StudentServiceImpl ss; // 注入 service 层
	//
	//// @RequestMapping(value = "/student", method = RequestMethod.GET)
	//// public ModelAndView showForm() {
	//// return new ModelAndView("add_student_form", "student", new Student());
	//// }
	//
	// @RequestMapping(value = "/student/all")
	// public String findAll(Map<String,Object> model){ // 声明 model 用来传递数据
	// List<Student> studentList = ss.findAll();
	// model.put("studentList",studentList); // 通过这一步，JSP 页面就可以访问 studentList
	// return "student_list"; // 跳转到 jPersonList 页面
	// }
	//
	// @RequestMapping(value = "/student/add", method = RequestMethod.GET)
	// public ModelAndView toCteateStudentInfo(){ // 跳转新增页面
	// System.out.println("here");
	// return new ModelAndView("add_student_form","student",new Student());
	//
	// }
	//
	//
	// @RequestMapping(value = "/student/confirmAddStudent", method =
	// RequestMethod.POST)
	// public String submit(@ModelAttribute("student")Student student,
	// BindingResult result, ModelMap model, HttpSession session) {
	// if (result.hasErrors()) {
	// System.out.println(result.getAllErrors().get(0));
	// return "error";
	// }
	// session.setAttribute("studentInfo", student);
	//
	// model.addAttribute("sname", student.getSname());
	// model.addAttribute("ssex", student.getSsex());
	// model.addAttribute("sdob", student.getSdob());
	// model.addAttribute("id", student.getId());
	// return "student_view";
	// }
	//
	// @RequestMapping(value = "/student/updateStudentList")
	// public String updateStudentList(HttpSession session){
	// Student student = (Student)session.getAttribute("studentInfo");
	// System.out.println(student.toString());
	// ss.insert(student); // 调用 Service 层方法，插入数据
	// return "redirect:/student/all.action"; // 转向人员列表 action
	// }

}