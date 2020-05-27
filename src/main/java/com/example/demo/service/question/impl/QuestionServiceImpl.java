package com.example.demo.service.question.impl;

import com.example.demo.entity.question.Question;
import com.example.demo.mapper.question.QuestionMapper;
import com.example.demo.service.question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 17:49 2020/4/26
 */
@Service
public class QuestionServiceImpl implements QuestionService {

    final
    QuestionMapper questionMapper;

    public QuestionServiceImpl(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    @Override
    public List<Question> listQuestion()throws Exception{
        List<Question> list=questionMapper.listQuestion();
        return list;
    }

    @Override
    public boolean addQuestion(Question question)throws Exception{
        boolean a=questionMapper.addQuestion(question);
        return a;
    }

    @Override
    public boolean delQuestion(int qid) throws Exception{
        boolean a = questionMapper.delQuestion(qid);
        return a;
    }

    @Override
    public boolean updateAnswer(int qid,String answer) throws Exception{
        boolean a = questionMapper.updateAnswer(qid,answer);
        return a;
    }
}
