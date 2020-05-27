package com.example.demo.service.paper;

import com.example.demo.entity.paper.Paper;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:43 2020/4/26
 */
public interface PaperService {
    public List<Paper> listPaper() throws Exception;
    public boolean addPaper(Paper paper) throws Exception;
    public boolean delPaper(int pid)throws Exception;
    public boolean updatePname(int pid,String pname)throws Exception;
}
