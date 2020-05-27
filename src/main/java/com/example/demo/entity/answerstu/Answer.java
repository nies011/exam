package com.example.demo.entity.answerstu;

/**
 * @Author: nie
 * @Description:
 * @Date: 12:59 2020/5/14
 */
public class Answer {
    private int quid,uid,pid;
    private String answer;

    public int getQuid() {
        return quid;
    }

    public void setQuid(int quid) {
        this.quid = quid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
