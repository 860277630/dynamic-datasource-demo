package com.example.dynamicdatasourcemybatis.dao;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.example.dynamicdatasourcemybatis.model.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper {

    @DS("master")
    User Sel(int id);

    @DS("slave_1")
    Integer insertUser(User u);
}
