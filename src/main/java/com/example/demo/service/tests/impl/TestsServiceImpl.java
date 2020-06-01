package com.example.demo.service.tests.impl;

import com.example.demo.entity.tests.Tests;
import com.example.demo.mapper.tests.TestsMapper;
import com.example.demo.service.tests.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 16:52 2020/5/2
 */
@Service
public class TestsServiceImpl implements TestsService {

    final
    TestsMapper testsMapper;

    public TestsServiceImpl(TestsMapper testsMapper) {
        this.testsMapper = testsMapper;
    }

    @Override
    public List<Tests> listTests() throws Exception{
        return testsMapper.listTests();
    }

    @Override
    public boolean addTests(Tests tests) throws Exception{
        return testsMapper.addTests(tests);
    }

    @Override
    public boolean delTests(Integer teid) throws Exception{
        return testsMapper.delTests(teid);
    }

    @Override
    public boolean updateScore(Integer teid,int score) throws Exception{
        return testsMapper.updateScore(teid,score);
    }
}
