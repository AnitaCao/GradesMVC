package com.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.Teacher;
import com.mvc.service.TeacherService;

@Controller

public class TeacherController {

	@Autowired
	private TeacherService teacherService; // 注入 service 层

	@Autowired
    MessageSource messageSource;
	
	
	@RequestMapping(value = "/teacher/all", method = RequestMethod.GET)
	public String listTeacher(Model model) {
		model.addAttribute("teacher", new Teacher());
		model.addAttribute("listTeachers", this.teacherService.listTeachers());
		return "teacher_list";
	}

	   /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/teacher/new" }, method = RequestMethod.GET)
    public String newTeacher(ModelMap model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        model.addAttribute("edit", false);
        return "add_teacher_form";
    }
    
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "teacher/new" }, method = RequestMethod.POST)
    public String saveTeacher(@Valid Teacher teacher, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "add_teacher_form";
        }
         
        this.teacherService.addTeacher(teacher);
        model.addAttribute("type","teacher");
        model.addAttribute("success", "Teacher " + teacher.getTname() + " registered successfully");
        return "success";
    }
    
    
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{id}-teacher" }, method = RequestMethod.GET)
    public String editTeacher(@PathVariable int id, ModelMap model) {
    	Teacher teacher = this.teacherService.getTeacherById(id);
        model.addAttribute("teacher", teacher);
        model.addAttribute("edit", true);
        return "add_teacher_form";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-teacher" }, method = RequestMethod.POST)
    public String updateTeacher(@Valid Teacher teacher, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "add_teacher_form";
        }
        this.teacherService.updateTeacher(teacher);
        model.addAttribute("type","teacher");
        model.addAttribute("success", "teacher " + teacher.toString()  + " updated successfully");
        return "success";
    }
    
    /*
     * This method will delete a student by it's id.
     */
    @RequestMapping(value = { "/delete-{id}-teacher" }, method = RequestMethod.GET)
    public String deleteTeacher(@PathVariable int id) {
        this.teacherService.removeTeacher(id);
        return "redirect:/teacher/all";
    }


}