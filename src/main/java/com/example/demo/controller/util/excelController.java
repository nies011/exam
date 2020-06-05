package com.example.demo.controller.util;

import com.example.demo.entity.student.Student;
import com.example.demo.service.student.StudentService;
import com.example.demo.util.enums.FileEnum;
import com.example.demo.util.file.ExcelUtil;
import com.example.demo.util.file.TxtUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: nie
 * @Description:
 * @Date: 18:34 2020/5/27
 */
@RestController
@RequestMapping("excel")
@CrossOrigin
public class excelController {
    final
    StudentService studentService;

    public excelController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("exportStudent")
    public String exportStudent() throws Exception{
        List<Student> students = studentService.listStudent();
        HashMap<Integer,Object> cellHash = new HashMap<>();
        HashMap<Integer,HashMap> sheetHash = new HashMap<>();
        HashMap<Integer,HashMap> rowHash = new HashMap<>();
        HashMap<Integer,String> nameHash = new HashMap<>();
        HashMap<String,HashMap> hashMap = new HashMap<>();

            for (int i = 0; i <= students.size(); i++) {
                if (i == 0) {
                    cellHash.put(0, FileEnum.STUDENT_ID.getMsg());
                    cellHash.put(1, FileEnum.STUDENT_NAME.getMsg());
                    cellHash.put(2, FileEnum.STUDENT_PHONE.getMsg());
                    cellHash.put(3, FileEnum.STUDENT_EMAIL.getMsg());
                    cellHash.put(4, FileEnum.STUDENT_CLASS.getMsg());
                }else{
                    cellHash.put(0,students.get(i-1).getUid());
                    cellHash.put(1,students.get(i-1).getUname());
                    cellHash.put(2,students.get(i-1).getPhone());
                    cellHash.put(3,students.get(i-1).getEmail());
                    cellHash.put(4,students.get(i-1).getUclass());
                }
                rowHash.put(i,(HashMap)cellHash.clone());
            }
        sheetHash.put(0,rowHash);
        nameHash.put(0,"学生信息");
        hashMap.put("name",nameHash);
        hashMap.put("sheet",sheetHash);
        return  ExcelUtil.exportExcel(hashMap,"学生信息.xls",15);
    }

    @RequestMapping("downLoadStudent")
    public String downLoadStudent(HttpServletResponse response) throws Exception{
        List<Student> students = studentService.listStudent();
        HashMap<Integer,Object> cellHash = new HashMap<>();
        HashMap<Integer,HashMap> sheetHash = new HashMap<>();
        HashMap<Integer,HashMap> rowHash = new HashMap<>();
        HashMap<Integer,String> nameHash = new HashMap<>();
        HashMap<String,HashMap> hashMap = new HashMap<>();

        for (int i = 0; i <= students.size(); i++) {
            if (i == 0) {
                cellHash.put(0, FileEnum.STUDENT_ID.getMsg());
                cellHash.put(1, FileEnum.STUDENT_NAME.getMsg());
                cellHash.put(2, FileEnum.STUDENT_PHONE.getMsg());
                cellHash.put(3, FileEnum.STUDENT_EMAIL.getMsg());
                cellHash.put(4, FileEnum.STUDENT_CLASS.getMsg());
            }else{
                cellHash.put(0,students.get(i-1).getUid());
                cellHash.put(1,students.get(i-1).getUname());
                cellHash.put(2,students.get(i-1).getPhone());
                cellHash.put(3,students.get(i-1).getEmail());
                cellHash.put(4,students.get(i-1).getUclass());
            }
            rowHash.put(i,(HashMap)cellHash.clone());
        }
        sheetHash.put(0,rowHash);
        nameHash.put(0,"学生信息");
        hashMap.put("name",nameHash);
        hashMap.put("sheet",sheetHash);
        return ExcelUtil.downloadExcel(response,"学生信息.xls",ExcelUtil.getHSSFWork(hashMap,"学生信息.xls",15));
    }

    @RequestMapping("readExcel")
    public void readExcel(MultipartFile multipartFile) throws Exception{
        boolean jur;
        List<Student> students = ExcelUtil.readExcel(TxtUtil.transport(multipartFile));
        List<Student> studentList = studentService.listStudent();
        for (Student s:students
             ) {
            jur = true;
            if (studentList.equals(null)){
                studentService.addStudent(s);
            } else {
                for (Student st:studentList
                ) {
                    if (s.getUid()==st.getUid()) {
                        jur = false;
                    }
                }
            }
            if (jur){
                studentService.addStudent(s);
            }
        }

    }
}
