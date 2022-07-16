package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;

public interface UserService {
    //用户注册
    void register(User User, Role role);
}
