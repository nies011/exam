package com.example.demo.entity.tests;

import java.util.Date;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:35 2020/5/1
 */
public class Tests {
    private Integer teId;
    private Integer uid;
    private Integer pid;
    private Date startTime;
    private Date endTime;
    private String time;
    private int score;

    public Integer getTeId() {
        return teId;
    }

    public void setTeId(Integer teId) {
        this.teId = teId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
