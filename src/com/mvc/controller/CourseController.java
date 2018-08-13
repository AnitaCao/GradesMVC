package com.mvc.controller;


import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.domain.Course;
import com.mvc.service.CourseService;

@Controller

public class CourseController {

	@Autowired
	private CourseService courseService; // 注入 service 层

	@Autowired
    MessageSource messageSource;
	
	
	@RequestMapping(value = "/course/all", method = RequestMethod.GET)
	public String listCourses(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("listCourses", this.courseService.listCourses());
		return "course_list";
	}

	   /*
     * This method will provide the medium to add a new employee.
     */
    @RequestMapping(value = { "/course/new" }, method = RequestMethod.GET)
    public String newCourse(ModelMap model) {
        Course course = new Course();
        model.addAttribute("course", course);
        model.addAttribute("edit", false);
        return "add_course_form";
    }
    
    /*
     * This method will be called on form submission, handling POST request for
     * saving employee in database. It also validates the user input
     */
    @RequestMapping(value = { "course/new" }, method = RequestMethod.POST)
    public String saveCourse(@Valid Course course, BindingResult result,
            ModelMap model) {
 
        if (result.hasErrors()) {
            return "add_course_form";
        }
 
        /*
         * Preferred way to achieve uniqueness of field [code] should be implementing custom @Unique annotation 
         * and applying it on field [code] of Model class [Course].
         * 
         * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
         * framework as well while still using internationalized messages.
         * 
         */
        if(!this.courseService.isCourseCodeUnique(course.getId(), course.getCode())){
            FieldError ssnError =new FieldError("course","code",messageSource.getMessage("non.unique.code", new String[]{course.getCode()}, Locale.getDefault()));
            result.addError(ssnError);
            return "add_course_form";
        }
         
        this.courseService.addCourse(course);
        model.addAttribute("type","course");
        model.addAttribute("success", "Course " + course.getCode() + " registered successfully");
        return "success";
    }
    
    
    /*
     * This method will provide the medium to update an existing employee.
     */
    @RequestMapping(value = { "/edit-{id}-course" }, method = RequestMethod.GET)
    public String editCourse(@PathVariable int id, ModelMap model) {
        Course course = this.courseService.getCourseById(id);
        model.addAttribute("course", course);
        model.addAttribute("edit", true);
        return "add_course_form";
    }
     
    /*
     * This method will be called on form submission, handling POST request for
     * updating employee in database. It also validates the user input
     */
    @RequestMapping(value = { "/edit-{id}-course" }, method = RequestMethod.POST)
    public String updateCourse(@Valid Course course, BindingResult result,
            ModelMap model, @PathVariable int id) {
 
        if (result.hasErrors()) {
            return "add_course_form";
        }
        this.courseService.updateCourse(course);
        model.addAttribute("type","course");
        model.addAttribute("success", "Course " + course.toString()  + " updated successfully");
        return "success";
    }
    
    /*
     * This method will delete a student by it's id.
     */
    @RequestMapping(value = { "/delete-{id}-course" }, method = RequestMethod.GET)
    public String deleteCourse(@PathVariable int id) {
        this.courseService.removeCourse(id);
        return "redirect:/course/all";
    }


}