package com.example.controller;

import com.example.entity.Role;
import com.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


//用户开发功能
@RestController
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService UserService;

    public UserController(com.example.service.UserService userService) {
        UserService = userService;
    }
    /*
     *用户注册
     *@return
     */
    @RequestMapping("register")
    public  String register(User user,Role role) throws UnsupportedEncodingException {

        log.debug("用户名：{},邮箱：{}，密码：{}，类别：{}",user.getUName(),user.getUPassword(),user.getMail(),role.getRtype());
        try {
            //1,注册用户
            UserService.register(user,role);

        }catch (RuntimeException e){
            e.printStackTrace();
            return "redirect:/register.jsp?msg=" + URLEncoder.encode(e.getMessage(),"UTF-8");
        }

        return "redirect:/login.jsp";
    }
}
