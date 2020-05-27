package com.example.demo.service.admin;

import com.example.demo.entity.admin.Admin;

import java.util.List;

/**
 * @Author: Liu
 * @Description:
 * @Date: 15:33 2020/4/22
 */
public interface AdminService {
    /**
     * admin
     * @return list
     * @throws Exception null
     */
    List<Admin> listAdmin() throws Exception;

    /**
     * admin
     * @param username username
     * @param pwd pwd
     * @return boolean
     * @throws Exception null
     */
    boolean login(String username,String pwd)throws Exception;

    /**
     * add
     * @param admin admin
     * @return boolean
     * @throws Exception null
     */
    boolean addAdmin(Admin admin)throws Exception;

    /**
     * delete
     * @param name name
     * @return list
     * @throws Exception null
     */
    boolean delAdmin(String name)throws Exception;

    /**
     * update
     * @param name name
     * @param id id
     * @return boolean
     * @throws Exception null
     */
    boolean updateName(String name,int id)throws Exception;

    /**
     * updatePwd
     * @param id id
     * @param pwd pwd
     * @return boolean
     * @throws Exception null
     */
    boolean updatePwd(String pwd,int id)throws Exception;
}
