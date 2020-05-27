package com.example.demo.service.answerstu.impl;

import com.example.demo.entity.answerstu.Answerstu;
import com.example.demo.mapper.answerstu.AnswerstuMapper;
import com.example.demo.service.answerstu.AnswerstuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 21:46 2020/5/3
 */
@Service
public class AnswerstuServiceImpl implements AnswerstuService {

    final
    AnswerstuMapper answerstuMapper;

    public AnswerstuServiceImpl(AnswerstuMapper answerstuMapper) {
        this.answerstuMapper = answerstuMapper;
    }

    @Override
    public List<Answerstu> listAnswerstu() throws Exception{
        List<Answerstu> list = answerstuMapper.listAnswerstu();
        return list;
    }

    @Override
    public boolean addAnswerstu(Answerstu answerstu) throws Exception{
        boolean a = answerstuMapper.addAnswerstu(answerstu);
        return a;
    }

    @Override
    public boolean delAnswerstu(int anid) throws Exception{
        boolean a = answerstuMapper.delAnswerstu(anid);
        return a;
    }


}
