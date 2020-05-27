package com.example.demo.entity.paper;

import java.util.Date;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:38 2020/4/26
 */
public class Paper {
    private Integer pid;
    private String pname;
    private Integer ptime;
    private Integer tid;
    private Date deadline;
    private Integer queNum;
    private Integer blankNum;
    private Integer subNum;
    private Integer num;
    private String judScore;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getJudScore() {
        return judScore;
    }

    public void setJudScore(String judScore) {
        this.judScore = judScore;
    }

    public Integer getQueNum() {
        return queNum;
    }

    public void setQueNum(Integer queNum) {
        this.queNum = queNum;
    }

    public Integer getBlankNum() {
        return blankNum;
    }

    public void setBlankNum(Integer blankNum) {
        this.blankNum = blankNum;
    }

    public Integer getSubNum() {
        return subNum;
    }

    public void setSubNum(Integer subNum) {
        this.subNum = subNum;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getPtime() {
        return ptime;
    }

    public void setPtime(Integer ptime) {
        this.ptime = ptime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
}
