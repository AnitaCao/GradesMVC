package com.mvc.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.domain.Course;
import com.mvc.domain.Student;
import com.mvc.service.CourseService;
import com.mvc.service.StudentService;

@Controller
@SessionAttributes("available_courses")
public class StudentFormController {

	@Autowired
	private StudentService studentService; // 注入 service 层
	
	@Autowired
	private CourseService courseService;

	@RequestMapping(value = "/student/all", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("listStudents", this.studentService.listStudents());
		return "student_list";
	}

	@RequestMapping(value = "/student/new", method = RequestMethod.GET)
	public ModelAndView showForm() {
		return new ModelAndView("add_student_form", "student", new Student());
	 }
	
    /*
     * This method will be called on form submission, handling POST request for
     * saving student in database. It also validates the user input
     */
    @RequestMapping(value = { "student/new" }, method = RequestMethod.POST)
    public String saveStudent(@Valid Student student, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "add_student_form";
        }
        this.studentService.addStudent(student);
        model.addAttribute("type","student");
        model.addAttribute("success", "Student " + student.getSname() + " registered successfully");
        return "success";
    }
	 
    
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.GET)
    public String editStudent(@PathVariable int id, ModelMap model) {
        Student student = this.studentService.getStudentById(id);
        model.addAttribute("student", student);
        model.addAttribute("edit", true);
        return "add_student_form";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-student" }, method = RequestMethod.POST)
    public String updateStudent(@Valid Student student, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "add_student_form";
        }
        this.studentService.updateStudent(student);
        model.addAttribute("type","student");
        model.addAttribute("success", "Student " + student.toString()  + " updated successfully");
        return "success";
    }
    
    /*
     * This method will delete a student by it's id.
     */
    @RequestMapping(value = { "/delete-{id}-student" }, method = RequestMethod.GET)
    public String deleteStudent(@PathVariable int id) {
        this.studentService.removeStudent(id);
        return "redirect:/student/all";
    }
    
    /**
     * This method will provide courses list to views
     */
    @ModelAttribute("available_courses")
    public List<Course> initializeProfiles() {
        return courseService.listCourses();
    }


}