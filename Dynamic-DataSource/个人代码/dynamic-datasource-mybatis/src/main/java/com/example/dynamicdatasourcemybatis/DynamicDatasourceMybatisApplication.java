package com.example.dynamicdatasourcemybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.example.dynamicdatasourcemybatis.dao")//是mapper接口，而不是映射文件
@SpringBootApplication
public class DynamicDatasourceMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(DynamicDatasourceMybatisApplication.class, args);
    }

}
