package com.example.demo.service.blank;

import com.example.demo.entity.blank.Blank;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 15:07 2020/5/1
 */
public interface BlankService {

    public List<Blank> listBlank() throws Exception;
    public boolean addBlank(Blank blank) throws Exception;
    public boolean delBlank(int bid) throws Exception;
    public boolean updateAnswer(int bid,String answer) throws Exception;
}
