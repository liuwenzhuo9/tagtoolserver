package com.example.tagtool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.tagtool.tagDao")//扫描指定包的接口
public class TagtoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(TagtoolApplication.class, args);
    }

}
