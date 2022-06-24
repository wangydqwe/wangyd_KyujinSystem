package com.example.dao;

import com.example.entity.User;

public interface Userdao {
    //根据用户名查询用户
    User findByUserName(String username);
    //注册用户
    void save(User user);
}
