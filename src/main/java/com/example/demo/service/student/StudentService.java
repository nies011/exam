package com.example.demo.service.student;

import com.example.demo.entity.student.Student;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:56 2020/4/22
 */
public interface StudentService {
    public List<Student> listStudent() throws Exception;
    public boolean login(String username,String pwd)throws Exception;
    public boolean addStudent(Student student)throws Exception;
    public boolean delStudent(int uid)throws Exception;
    public boolean updatePwd(String pwd,Integer uid)throws Exception;
}
