package com.example.dynamicdatasourcemybatis.service;


import com.example.dynamicdatasourcemybatis.dao.UserMapper;
import com.example.dynamicdatasourcemybatis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;


@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    //分库分表  中 从 test 库中查找
    public User Sel(int id){
        return userMapper.Sel(id);
    }


    //分库分表  中 存入 user 库
    public Integer insertUser(){
        User user = new User();
        user.setId(1000+new Random().nextInt());
        user.setPassWord(UUID.randomUUID().toString());
        user.setUserName("张老三");
        user.setRealName("张三");
        return userMapper.insertUser(user);
    }

    public Integer testTrans(){
        User user = new User();
        user.setId(1000+new Random().nextInt());
        user.setPassWord(UUID.randomUUID().toString());
        user.setUserName("李老四");
        user.setRealName("李四");
        userMapper.insertUser(user);
        System.out.println("==========构建错误，测试回滚==============");
        System.out.println(1/0);
        return 0;


    }




}

