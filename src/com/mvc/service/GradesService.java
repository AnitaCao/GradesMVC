package com.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mvc.domain.Course;
import com.mvc.domain.Grade;
import com.mvc.domain.Student;

@Service
public class GradesService {  // 模拟内存数据库，准备数据
    // 声明一个容器
    private Grade[] grades = new Grade[10];
    
    @Resource
    StudentService ss;    // 注入 service 层
    
    @Resource
    CourseService cs;
    
    // 获取人员列表
    public Grade[] findAll(){
    	List<Student> studentList = ss.findAll();
    	List<Course> courseList = cs.findAll();
    	
    	for (int i = 0; i < 10; i++) {
            Grade g = new Grade();
            g.setId(i);
            g.setStudent(studentList.get(i));
            g.setCourse(courseList.get(i));
            g.setGrade(70 + i);
            grades[i] = g;
        }
        // 将 map 对象转换为 list 结合
        return grades;
    }
}