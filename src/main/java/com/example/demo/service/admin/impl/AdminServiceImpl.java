package com.example.demo.service.admin.impl;

import com.example.demo.entity.admin.Admin;
import com.example.demo.mapper.admin.AdminMapper;
import com.example.demo.service.admin.AdminService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liu
 * @Description:
 * @Date: 15:34 2020/4/22
 */
@Service
public class AdminServiceImpl implements AdminService {

    final
    AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public List<Admin> listAdmin() throws Exception{
        return adminMapper.listAdmin();
    }

    @Override
    public boolean addAdmin(Admin admin)throws Exception{
        return adminMapper.addAdmin(admin);
    }

    @Override
    public boolean delAdmin(String name)throws Exception{
        return adminMapper.delAdmin(name);
    }

    @Override
    public boolean updateName(String name, int id)throws Exception{
        return adminMapper.updateAname(name,id);
    }

    @Override
    public boolean updatePwd(String pwd,int id)throws Exception{
        return adminMapper.updatePwd(pwd,id);
    }

    @Override
    public boolean login(String username, String pwd) throws Exception {
        List<Admin> admins = adminMapper.listAdmin();
        for (Admin admin : admins) {
            if (username.equals(admin.getAname()) && pwd.equals(admin.getPwd())) {
                return true;
            }
        }
        return false;
    }
}
