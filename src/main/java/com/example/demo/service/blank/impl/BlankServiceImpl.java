package com.example.demo.service.blank.impl;

import com.example.demo.entity.blank.Blank;
import com.example.demo.mapper.blank.BlankMapper;
import com.example.demo.service.blank.BlankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:08 2020/5/1
 */
@Service
public class BlankServiceImpl implements BlankService {

    final
    BlankMapper blankMapper;

    public BlankServiceImpl(BlankMapper blankMapper) {
        this.blankMapper = blankMapper;
    }

    @Override
    public List<Blank> listBlank() throws Exception{
        List<Blank> list = blankMapper.listBlank();
        return list;
    }

    @Override
    public boolean addBlank(Blank blank) throws Exception{
        boolean a = blankMapper.addBlank(blank);
        return a;
    }

    @Override
    public boolean delBlank(int bid) throws Exception{
        boolean a = blankMapper.delBlank(bid);
        return a;
    }

    @Override
    public boolean updateAnswer(int bid,String answer) throws Exception{
        boolean a = blankMapper.updateAnswer(bid,answer);
        return a;
    }

}
