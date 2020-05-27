package com.example.demo.service.tests;

import com.example.demo.entity.tests.Tests;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:50 2020/5/2
 */
public interface TestsService {

    public List<Tests> listTests() throws Exception;
    public boolean addTests(Tests tests)throws Exception;
    public boolean delTests(Integer teid) throws Exception;
    public boolean updateScore(Integer teid,int score) throws Exception;
}
