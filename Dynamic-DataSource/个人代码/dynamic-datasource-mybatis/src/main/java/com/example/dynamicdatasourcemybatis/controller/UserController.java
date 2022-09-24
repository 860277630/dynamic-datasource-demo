package com.example.dynamicdatasourcemybatis.controller;

import com.example.dynamicdatasourcemybatis.model.User;
import com.example.dynamicdatasourcemybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Author:wjup
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 * 用多数据源来模拟分库分表   master 负责  读  操作  slave_1   负责  写操作
 */

@Controller
@RequestMapping("/testBoot")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id,Model model){
        User user =  userService.Sel(id);
        model.addAttribute("user", user);
        System.out.println("xxxxxxxxxxxxxxxxxx"+user.toString());
        return "index";
    }

    @RequestMapping("getUser/insert")
    @ResponseBody
    public String GetUser(){
        return String.valueOf(userService.insertUser());
    }


    //测试事务
    @RequestMapping("getUser/testTrans")
    @Transactional
    @ResponseBody
    public String testTrans(){
        return String.valueOf(userService.testTrans());
    }



}
