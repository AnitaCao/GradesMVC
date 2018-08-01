package com.mvc.controller;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.domain.Grade;
import com.mvc.service.GradesService;

@Controller

public class GradeFormController{
	
    @Resource
    GradesService gs;    // 注入 service 层

    @RequestMapping(value = "/grade/all")
    public String findAll(Map<String,Object> model){     // 声明 model 用来传递数据
        Grade[] gradesList = gs.findAll();
        model.put("gradesList",gradesList);              // 通过这一步，JSP 页面就可以访问 studentList
        return "grades_list";                    // 跳转到 jPersonList 页面
    }
    
}