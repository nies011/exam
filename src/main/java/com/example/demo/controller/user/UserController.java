package com.example.demo.controller.user;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.Controller;
import com.example.demo.entity.admin.Admin;
import com.example.demo.entity.student.Student;
import com.example.demo.entity.teacher.Teacher;
import com.example.demo.service.admin.AdminService;
import com.example.demo.service.student.StudentService;
import com.example.demo.service.teacher.TeacherService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpCookie;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: nie
 * @Description:
 * @Date: 9:57 2020/4/24
 */

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    final
    AdminService adminService;

    final
    TeacherService teacherService;

    final
    StudentService studentService;


    public UserController(AdminService adminService, TeacherService teacherService, StudentService studentService) {
        this.adminService = adminService;
        this.teacherService = teacherService;
        this.studentService = studentService;
    }

    @RequestMapping("login")
    public boolean login(Integer jur,String username,String pwd) throws Exception{
        if(jur == null){
            return false;
        }
        switch(jur){
            case 1:return adminService.login(username, pwd);
            case 2:return teacherService.login(username, pwd);
            case 3:return studentService.login(username, pwd);
            default:return false;
        }
    }

    @RequestMapping("register")
    public boolean register(@RequestBody String student)throws Exception{
        return studentService.addStudent(JSON.parseObject(student,Student.class));
    }

    @RequestMapping("listStudent")
    public List<Student> listStudent() throws Exception{
        return studentService.listStudent();
    }


    @RequestMapping("addTea")
    public boolean addTeacher(Integer uid)throws Exception{
        if(uid==null){
            return false;
        }
        Teacher teacher = new Teacher();
        for (int i = 0; i < studentService.listStudent().size(); i++) {
            if(studentService.listStudent().get(i).getUid() == uid){
                teacher.setTid(studentService.listStudent().get(i).getUid());
                teacher.setEmail(studentService.listStudent().get(i).getEmail());
                teacher.setPhone(studentService.listStudent().get(i).getPhone());
                teacher.setTname(studentService.listStudent().get(i).getUname());
                teacher.setPwd(studentService.listStudent().get(i).getPwd());
                return teacherService.addTeacher(teacher)&&studentService.delStudent(uid);
            }
        }
        return false;
    }

    @RequestMapping("updateStu")
    public boolean updateStudent(@RequestBody String student,Integer updUId) throws Exception{
        if(updUId == null){ return false; }
        return studentService.addStudent(JSON.parseObject(student,Student.class))&&studentService.delStudent(updUId);
    }

    @RequestMapping("updateTea")
    public boolean updateTeacher(@RequestBody String teacher,Integer updTId) throws Exception{
        if(updTId==null){ return false; }
        return teacherService.delTeacher(updTId)&&teacherService.addTeacher(JSON.parseObject(teacher,Teacher.class));
    }
    @RequestMapping("delStu")
    public boolean delStudent(Integer delId)throws Exception{
        if(delId == null){ return false; }
        return studentService.delStudent(delId);
    }

//    @RequestMapping("updateStuPwd")
//    public boolean updateStuPwd(String pwd,Integer uid)throws Exception{
//        return studentService.updatePwd(pwd,uid);
//    }

    @RequestMapping("listTea")
    public List<Teacher> listTeacher() throws Exception{
        return teacherService.listTeacher();
    }

    @RequestMapping("delTea")
    public boolean delTeacher(Integer delTId) throws Exception{
        if(delTId == null){
            return false;
        }
        return teacherService.delTeacher(delTId);
    }

//    @RequestMapping("updateTeaPwd")
//    public boolean updateTeaPwd(String pwd,Integer tid)throws Exception{
//        return teacherService.updatePwd(pwd,tid);
//
//    }

    @RequestMapping("listAdm")
    public List<Admin> listAdmin() throws Exception{
        return adminService.listAdmin();
    }

    @RequestMapping("addAdm")
    public boolean addAdmin(Admin admin) throws Exception{
        return adminService.addAdmin(admin);

    }

    @RequestMapping("delAdm")
    public boolean delAdmin(String name) throws Exception{
        return adminService.delAdmin(name);

    }

    @RequestMapping("searchStu")
    public List<Student> searchStu(String string) throws Exception{
        List<Student> list = new ArrayList<>();
        String id;
        List<Student> studentList = studentService.listStudent();
        for (Student student : studentList) {
            id = Integer.toString(student.getUid());
            if (id.contains(string) || student.getEmail().contains(string) || student.getPhone().contains(string) || student.getUclass().contains(string) || student.getUname().contains(string)) {
                list.add(student);
            }
        }
        return list;
    }

    @RequestMapping("searchTea")
    public List<Teacher> searchTea(String string) throws Exception{
        List<Teacher> list = new ArrayList<>();
        String id;
        List<Teacher> teacherList = teacherService.listTeacher();
        for (Teacher teacher : teacherList) {
            id = Integer.toString(teacher.getTid());
            if (id.contains(string) || teacher.getEmail().contains(string) || teacher.getPhone().contains(string) || teacher.getTname().contains(string)) {
                list.add(teacher);
            }
        }
        return list;
    }
}
