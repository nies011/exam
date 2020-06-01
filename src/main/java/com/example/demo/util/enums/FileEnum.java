package com.example.demo.util.enums;

/**
 * @Author: nie
 * @Description:
 * @Date: 18:42 2020/5/27
 */
public enum FileEnum {
    PATH_WEB("web-path","/opt/nies/files/"),
    PATH_LOCAL("local-path","D:/All My Work/join/others/files/"),
    STUDENT_ID("uid","学号"),
    STUDENT_NAME("uname","姓名"),
    STUDENT_PHONE("phone","电话"),
    STUDENT_EMAIL("email","邮箱"),
    STUDENT_CLASS("uclass","专业");
    private String code;
    private String msg;


    FileEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }
}
