package com.mvc.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.mvc.domain.Course;
import com.mvc.service.CourseService;

@Component
public class courseNameConverter implements Converter<Object, Course>{
 
    @Autowired
    CourseService courseService;
 
    /**
     * Gets Course by Id
     * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
     */
    public Course convert(Object element) {
        Integer id = Integer.parseInt((String)element);
        System.out.println("The id is: " + id);
        Course course= courseService.getCourseById(id);
        System.out.println("course : "+course.getCode());
        return course;
    }
     
}