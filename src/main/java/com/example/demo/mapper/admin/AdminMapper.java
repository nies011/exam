package com.example.demo.mapper.admin;

import com.example.demo.entity.admin.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:28 2020/4/22
 */
@Mapper
@Repository
public interface AdminMapper {
    public List<Admin> listAdmin() throws Exception;
    public boolean addAdmin(@Param("admin") Admin admin)throws Exception;
    public boolean delAdmin(String aname)throws Exception;
    public boolean updateAname(@Param("aname")String aname,@Param("aid")Integer aid)throws Exception;
    public boolean updatePwd(@Param("pwd")String pwd,@Param("aid")Integer aid)throws Exception;
}
