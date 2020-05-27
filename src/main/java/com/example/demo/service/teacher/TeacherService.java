package com.example.demo.service.teacher;

import com.example.demo.entity.student.Student;
import com.example.demo.entity.teacher.Teacher;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:20 2020/4/22
 */
public interface TeacherService {
    public List<Teacher> listTeacher() throws Exception;
    public boolean delTeacher(int tId)throws Exception;
    public boolean updatePwd(String pwd,Integer tid)throws Exception;
    public boolean addTeacher(Teacher teacher)throws Exception;
    public boolean login(String username,String pwd)throws Exception;
}
