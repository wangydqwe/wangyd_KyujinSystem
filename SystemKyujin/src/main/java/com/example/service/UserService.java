package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;

public interface UserService {
    //用户注册
    void register(User User, Role role, UserRole UserRole);
    //用户登录
    User login(String username,String password,String mail);
}
