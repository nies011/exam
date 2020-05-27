package com.example.demo.mapper.tests;

import com.example.demo.entity.tests.Tests;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:38 2020/5/1
 */
@Mapper
@Repository
public interface TestsMapper {

    public List<Tests> listTests() throws Exception;
    public boolean addTests(@Param("tests")Tests tests)throws Exception;
    public boolean delTests(@Param("teiId")Integer teid)throws Exception;
    public boolean updateScore(@Param("teId")Integer teid,@Param("score")int score)throws Exception;
}
