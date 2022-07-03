package com.example.service;

import com.example.dao.Userdao;
import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
//20220703 wangyide:serviceimplの追加

@Service
@Transactional
public class UserServiceImpl implements UserService{
    private final Userdao userdao;

    @Autowired
    public UserServiceImpl(Userdao userdao) {
        this.userdao = userdao;
    }

    @Override
    public void register(User user, Role role, UserRole userRole) {
        //Rtype
        if(role.getRtype() == 1){
            role.setRname("個人");
        }else if (role.getRtype() == 2){
            role.setRname("企業");
        }else if (role.getRtype() == 3){
            role.setRname("管理者");
        }else{
            role.setRname("システム管理者");
        }


        userdao.save(user);

        userdao.save2(role);

        //UId
        userRole.setUid(user.getUserId());
        //Rid
        userRole.setRid(role.getRid());
        //Uname
        userRole.setUname(user.getUName());
        //Rname
        userRole.setRname(role.getRname());

        userdao.save3(userRole);

    }

    @Override
    public User login(String username,String password,String mail){
        //1,根据输入的email查询数据是否存在
        User user = userdao.findByUserName(mail);
        //2.判断email
        if (!user.getMail().equals(mail)) throw new RuntimeException("email输入错误");
        //3.判断密码
        if (!user.getUPassword().equals(password)) throw new RuntimeException("密码输入错误");

        return user;
    }
}
