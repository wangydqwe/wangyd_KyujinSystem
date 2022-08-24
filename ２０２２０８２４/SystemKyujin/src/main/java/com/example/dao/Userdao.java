package com.example.dao;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
//20220806 wangyide:Userdaoクラスの作成
public interface Userdao {
    User findByUserName(String mail);
    //register機能
    void registerUser(User user);
    void registerRole(Role role);
    void registerUserRole(UserRole UserRole);
    //根据用户id查询角色
    String findByRoleName(Integer UserId);
    //根据角色名字查询用户角色种类
    Integer findByRoleType(String Rname);
}
