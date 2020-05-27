package com.example.demo.mapper.paper;

import com.example.demo.entity.paper.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:38 2020/4/26
 */
@Mapper
@Repository
public interface PaperMapper {
    public List<Paper> listPaper() throws Exception;
    public boolean addPaper(@Param("paper") Paper paper) throws Exception;
    public boolean delPaper(@Param("pid")int pid) throws Exception;
    public boolean updatePname(@Param("pid")int pid,@Param("pname")String pname)throws Exception;
}
