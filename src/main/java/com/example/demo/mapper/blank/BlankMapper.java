package com.example.demo.mapper.blank;

import com.example.demo.entity.blank.Blank;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.ManagedBean;
import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:02 2020/5/1
 */
@Mapper
@Repository
public interface BlankMapper {

    public List<Blank> listBlank() throws Exception;
    public boolean addBlank(@Param("blank")Blank blank) throws Exception;
    public boolean delBlank(@Param("bid")int bid)throws Exception;
    public boolean updateAnswer(@Param("bid")int bid,@Param("answer")String answer)throws Exception;
}
