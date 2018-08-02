package com.mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.dao.StudentDAO;
import com.mvc.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {  // 模拟内存数据库，准备数据
//    // 声明一个容器
//    private static Map<Integer, Student> map = new HashMap<Integer, Student>();
//
//    // 初始化 id
//    public static Integer id = 1;
//    
//    // 利用静态块初始化数据
//    static {
//        for (int i = 0; i < 10; i++) {
//            Student p = new Student();
//            p.setId(id++);
//            p.setSname("Charie"+i);
//            p.setSsex("f");
//            map.put(i,p);
//        }
//    }
//
//    // 获取人员列表
//	public List<Student> findAll(){
//        // 将 map 对象转换为 list 结合
//        return new ArrayList<Student>(map.values());
//    }
//	
//    // 新增人员信息
//    public void insert(Student s) {
//        id++;
//        s.setId(id);
//        map.put(id, s);
//    }

	private StudentDAO studentDAO;

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}
	
	@Override
	@Transactional
	public void addStudent(Student p) {
		this.studentDAO.addStudent(p);
	}

	@Override
	@Transactional
	public void updateStudent(Student p) {
		this.studentDAO.updateStudent(p);
	}

	@Override
	@Transactional
	public List<Student> listStudents() {
		return this.studentDAO.listStudents();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return this.studentDAO.getStudentById(id);
	}

	@Override
	@Transactional
	public void removeStudent(int id) {
		this.studentDAO.removeStudent(id);
	}
}