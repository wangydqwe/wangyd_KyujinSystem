package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//20220806 wangyide:MyMvcConfigクラスの作成

@Configuration   //相当于springmvc.xml
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //设置URL及其对应的jsp文件
        registry.addViewController("/").setViewName("toppage");

    }
}
