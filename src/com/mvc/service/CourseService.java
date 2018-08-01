package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mvc.domain.Course;

@Service
public class CourseService {  // 模拟内存数据库，准备数据
    // 声明一个容器
    private static Map<Integer, Course> map = new HashMap<Integer, Course>();

    // 利用静态块初始化数据
    static {
        for (int i = 0; i < 10; i++) {
            Course c = new Course();
            c.setId(i);
            c.setTitle("Dave" + i);
            c.setContent("this course is: " + i);
            map.put(i,c);
        }
    }

    // 获取人员列表
    public List<Course> findAll(){
        // 将 map 对象转换为 list 结合
        return new ArrayList<Course>(map.values());
    }
}