package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mvc.domain.Student;

@Service
public class StudentService {  // 模拟内存数据库，准备数据
    // 声明一个容器
    private static Map<Integer, Student> map = new HashMap<Integer, Student>();

    // 利用静态块初始化数据
    static {
        for (int i = 0; i < 10; i++) {
            Student p = new Student();
            p.setId(i);
            p.setSname("Charie"+i);
            p.setSsex("f");
            map.put(i,p);
        }
    }

    // 获取人员列表
	public List<Student> findAll(){
        // 将 map 对象转换为 list 结合
        return new ArrayList<Student>(map.values());
    }
}