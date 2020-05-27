package com.example.demo.entity.answerstu;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 21:38 2020/5/3
 */
public class Answerstu {
    private Integer anid;
    private Integer uid;
    private Integer pid;
    private Integer quid;
    private String sanswer;
    private String statement;
    private Integer teid;
    private String corrAns;


    public String getCorrAns() {
        return corrAns;
    }

    public void setCorrAns(String corrAns) {
        this.corrAns = corrAns;
    }

    public Integer getAnid() {
        return anid;
    }

    public void setAnid(Integer anid) {
        this.anid = anid;
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

    public Integer getQuid() {
        return quid;
    }

    public void setQuid(Integer quid) {
        this.quid = quid;
    }

    public String getSanswer() {
        return sanswer;
    }

    public void setSanswer(String sanswer) {
        this.sanswer = sanswer;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public Integer getTeid() {
        return teid;
    }

    public void setTeid(Integer teid) {
        this.teid = teid;
    }
}
