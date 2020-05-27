package com.example.demo.service.student.impl;

import com.example.demo.entity.student.Student;
import com.example.demo.mapper.student.StudentMapper;
import com.example.demo.service.student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:57 2020/4/22
 */
@Service
public class StudentServiceImpl implements StudentService {

    final StudentMapper studentMapper;

    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> listStudent() throws Exception{
        return studentMapper.listStudent();

    }

    @Override
    public boolean addStudent(Student student)throws Exception{
        return studentMapper.addStudent(student);
    }

    @Override
    public boolean delStudent(int uid)throws Exception{
        return studentMapper.delStudent(uid);
    }

    @Override
    public boolean updatePwd(String pwd,Integer uid)throws Exception{
        return studentMapper.updatePwd(pwd,uid);
    }

    @Override
    public boolean login(String username, String pwd) throws Exception {
        List<Student> students = studentMapper.listStudent();
        for (int i = 0; i <students.size(); i++) {
            if(username.equals(students.get(i).getUname())&&pwd.equals(students.get(i).getPwd())) {return true;}
        }
        return false;
    }
}
