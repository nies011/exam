package com.example.demo.service.answerstu;

import com.example.demo.entity.answerstu.Answerstu;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 21:45 2020/5/3
 */
public interface AnswerstuService {
    public List<Answerstu> listAnswerstu() throws Exception;
    public boolean addAnswerstu(Answerstu answerstu)throws Exception;
    public boolean delAnswerstu(int anid) throws Exception;
}
