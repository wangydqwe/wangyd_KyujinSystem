package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//20220806 wangyide:SystemKyujinApplicationの作成
@SpringBootApplication
@MapperScan("com.example.dao")
    public class SystemKyujinApplication {

        public static void main(String[] args) {
        SpringApplication.run(SystemKyujinApplication.class, args);
    }

}
