package com.example.demo.entity.student;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:52 2020/4/22
 */
public class Student {
    private Integer uid;
//    private String Uid;
    private String uname;
    private String pwd;
    private String phone;
    private String email;
    private String uclass;

//    public String getId(){
//        return Uid;
//    }
    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", uclass='" + uclass + '\'' +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUclass() {
        return uclass;
    }

    public void setUclass(String uclass) {
        this.uclass = uclass;
    }
}
