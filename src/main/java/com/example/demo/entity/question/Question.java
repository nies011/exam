package com.example.demo.entity.question;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 17:43 2020/4/26
 */
public class Question {
    private Integer qid;
    private String content;
    private String aoption;
    private String boption;
    private String coption;
    private String doption;
    private String answer;
    private Integer pid;

    public Integer getQid() {
        return qid;
    }

    public void setQid(Integer qid) {
        this.qid = qid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAoption() {
        return aoption;
    }

    public void setAoption(String aoption) {
        this.aoption = aoption;
    }

    public String getBoption() {
        return boption;
    }

    public void setBoption(String boption) {
        this.boption = boption;
    }

    public String getCoption() {
        return coption;
    }

    public void setCoption(String coption) {
        this.coption = coption;
    }

    public String getDoption() {
        return doption;
    }

    public void setDoption(String doption) {
        this.doption = doption;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
