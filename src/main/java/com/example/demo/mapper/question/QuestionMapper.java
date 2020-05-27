package com.example.demo.mapper.question;

import com.example.demo.entity.question.Question;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 17:45 2020/4/26
 */
@Mapper
@Repository
public interface QuestionMapper {
    public List<Question> listQuestion() throws Exception;
    public boolean addQuestion(@Param("question")Question question)throws Exception;
    public boolean delQuestion(@Param("qid")int qid)throws Exception;
    public boolean updateAnswer(@Param("qid")int qid,@Param("answer")String answer)throws Exception;
}
