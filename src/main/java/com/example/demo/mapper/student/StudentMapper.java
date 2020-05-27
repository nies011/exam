package com.example.demo.mapper.student;

import com.example.demo.entity.student.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:54 2020/4/22
 */
@Mapper
@Repository
public interface StudentMapper {
    public List<Student> listStudent() throws Exception;
    public boolean addStudent(@Param("student") Student student)throws Exception;
    public boolean delStudent(@Param("uid") int uid)throws Exception;
    public boolean updatePwd(@Param("pwd") String pwd, @Param("uid") Integer uid)throws Exception;
}
