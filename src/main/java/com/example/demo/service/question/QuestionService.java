package com.example.demo.service.question;

import com.example.demo.entity.question.Question;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 17:49 2020/4/26
 */
public interface QuestionService {
    public List<Question> listQuestion() throws Exception;
    public boolean addQuestion(Question question)throws Exception;
    public boolean delQuestion(int qid)throws Exception;
    public boolean updateAnswer(int qid,String answer)throws Exception;
}
