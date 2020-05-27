package com.example.demo.service.paper.impl;

import com.example.demo.entity.paper.Paper;
import com.example.demo.mapper.paper.PaperMapper;
import com.example.demo.service.paper.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:44 2020/4/26
 */
@Service
public class PaperServiceImpl implements PaperService {

    final
    PaperMapper paperMapper;

    public PaperServiceImpl(PaperMapper paperMapper) {
        this.paperMapper = paperMapper;
    }

    @Override
    public List<Paper> listPaper() throws Exception{
        List<Paper> list = paperMapper.listPaper();
        return list;
    }

    @Override
    public boolean addPaper(Paper paper)throws Exception{
        boolean a=paperMapper.addPaper(paper);
        return a;
    }

    @Override
    public boolean delPaper(int pid) throws Exception{
        boolean a=paperMapper.delPaper(pid);
        return a;
    }

    @Override
    public boolean updatePname(int pid,String pname)throws Exception{
        boolean a = paperMapper.updatePname(pid,pname);
        return a;
    }
}
