package com.example.dao;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;

public interface Userdao {
    //注册用户
    User findByUserName(String mail);
    void save(User user);
    void save2(Role role);
    void save3(UserRole UserRole);
}
