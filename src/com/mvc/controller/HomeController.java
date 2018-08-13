package com.mvc.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController{
	
	@RequestMapping(value={"/","/welcome"}, method = RequestMethod.GET)
	public ModelAndView helloWorld(){
		ModelAndView model = new ModelAndView("index");
//		model.addObject("msg", "hello world");
		return model;
	}
	
}
