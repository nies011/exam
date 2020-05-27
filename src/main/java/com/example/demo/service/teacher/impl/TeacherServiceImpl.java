package com.example.demo.service.teacher.impl;

import com.example.demo.entity.student.Student;
import com.example.demo.entity.teacher.Teacher;
import com.example.demo.mapper.teacher.TeacherMapper;
import com.example.demo.service.teacher.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: liuxj
 * @Description: service-teacher
 * @Date: 16:20 2020/4/22
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    final TeacherMapper teacherMapper;

    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Teacher> listTeacher() throws Exception{
        return teacherMapper.listTeacher();

    }

    @Override
    public boolean delTeacher(int tId)throws Exception{
        return teacherMapper.delTeacher(tId);
    }

    @Override
    public boolean updatePwd(String pwd,Integer tid)throws Exception{
        return teacherMapper.updatePwd(pwd,tid);
    }

    @Override
    public boolean addTeacher(Teacher teacher)throws Exception{
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public boolean login(String username, String pwd) throws Exception {
        List<Teacher> teachers = teacherMapper.listTeacher();
        for (int i = 0; i <teachers.size(); i++) {
            if(username.equals(teachers.get(i).getTname())&&pwd.equals(teachers.get(i).getPwd())) {return true;}
        }
        return false;
    }
}
