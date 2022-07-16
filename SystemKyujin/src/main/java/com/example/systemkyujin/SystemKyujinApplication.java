package com.example.systemkyujin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="controller")
@MapperScan("com.example.dao")
public class SystemKyujinApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemKyujinApplication.class, args);
    }

}
