package com.example.service;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//20220703 wangyide:serviceの追加
@Service
@Transactional
public interface UserService {
    //用户注册
    void register(User User, Role role, UserRole UserRole);
    //用户登录
    User login(String username,String password,String mail);
    //权限管理
    Integer userManage(String mail);

}
