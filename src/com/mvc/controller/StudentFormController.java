package com.mvc.controller;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.mvc.domain.Student;
import com.mvc.service.StudentService;

@Controller

public class StudentFormController{
	
    @Resource
    StudentService ss;    // 注入 service 层

	@RequestMapping(value = "/student", method = RequestMethod.GET)
    public ModelAndView showForm() {
        return new ModelAndView("add_student_form", "student", new Student());
    }
 
    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String submit(@ModelAttribute("student")Student student, 
      BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
        	System.out.println(result.getAllErrors().get(0));
            return "error";
        }
        model.addAttribute("sname", student.getSname());
        model.addAttribute("ssex", student.getSsex());
        model.addAttribute("sdob", student.getSdob());
        model.addAttribute("id", student.getId());
        return "student_view";
    }
    

    @RequestMapping(value = "/student/all")
    public String findAll(Map<String,Object> model){     // 声明 model 用来传递数据
        List<Student> studentList = ss.findAll();
        model.put("studentList",studentList);              // 通过这一步，JSP 页面就可以访问 studentList
        return "student_list";                    // 跳转到 jPersonList 页面
    }
    
}