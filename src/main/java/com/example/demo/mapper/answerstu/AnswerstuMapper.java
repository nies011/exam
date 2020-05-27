package com.example.demo.mapper.answerstu;

import com.example.demo.entity.answerstu.Answerstu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 21:41 2020/5/3
 */
@Mapper
@Repository
public interface AnswerstuMapper {
    public List<Answerstu> listAnswerstu() throws Exception;
    public boolean addAnswerstu(@Param("answerstu")Answerstu answerstu)throws Exception;
    public boolean delAnswerstu(@Param("anid")int anid) throws Exception;
}
