package com.wangyd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    /*
     *配置url【/】,映射到WEB-INF/index.html
     */
    @RequestMapping("/")
    public String toIndex(){
        return "index";
    }
}
