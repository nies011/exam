package com.example.demo.controller;

import com.example.demo.controller.paper.PaperController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @Author: nie
 * @Description:
 * @Date: 14:25 2020/4/23
 */
@CrossOrigin
@RestController
@RequestMapping("hello")
public class Controller {
    private static Logger logger = LoggerFactory.getLogger(Controller.class);
    @RequestMapping("hello")
    public String hello(){
        logger.info("测试路径成功！");
        return "hello";
    }

}



