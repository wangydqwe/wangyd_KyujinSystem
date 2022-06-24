package com.example.service;

import com.example.dao.Userdao;
import com.example.entity.Role;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private Userdao userdao;

    @Autowired
    public UserServiceImpl(Userdao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void register(User user,Role role) {

        //1.查询数据用户是否存在该用户名
        User userDB = userdao.findByUserName(user.getUName());
        if(!ObjectUtils.isEmpty(userDB))throw new RuntimeException("用户名已存在！");
        {

        //2.进行注册

            userdao.save(user);
        }
        //2.如果存在报错，用户名已经存在
        //3.如果不存在进行注册

    }

}
