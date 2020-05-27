package com.example.demo.mapper.teacher;

import com.example.demo.entity.student.Student;
import com.example.demo.entity.teacher.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:17 2020/4/22
 */
@Mapper
@Repository
public interface TeacherMapper {
    public List<Teacher> listTeacher() throws Exception;
    public boolean delTeacher(@Param("tId") int tId) throws Exception;
    public boolean updatePwd(@Param("pwd")String pwd, @Param("tid")Integer tid)throws Exception;
    public boolean addTeacher(@Param("teacher")Teacher teacher)throws Exception;
}
