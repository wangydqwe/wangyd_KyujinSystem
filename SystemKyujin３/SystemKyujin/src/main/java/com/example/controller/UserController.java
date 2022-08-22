package com.example.controller;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/*
 * ユーザー機能
 * クラス名：UserController
 * 機能：求人リストに関する機能
 * 引数：なし
 * 戻り値：なし
 * バージョン：1.000.000 by wangyd
 */
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService UserService;

    public UserController(com.example.service.UserService userService) {
        UserService = userService;
    }

    /*
     * manage機能
     * 関数名：manage
     * 機能：manage機能
     * 引数：String email
     * 　　　Model model
     * 戻り値：login
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/manage")
    public String manage(String email,Model model,HttpSession session){
        try {
            //Manage
            Integer roleType = UserService.userManage(email);
            model.addAttribute("rtype",roleType);
//2022.08.12 by wangyd add version.1.000.000
            session.setAttribute("rtype",roleType);
            return "forward:/login";
        }catch (Exception e){
            e.printStackTrace();
            return "forward:/login.jsp";
        }

    }

    /*
     * login機能
     * 関数名：login
     * 機能：login機能
     * 引数：String username
     *      String password
     *      String email
     * 　　　HttpSession session
     * 戻り値：toppage
     * バージョン：1.000.000 by wangyd
     */
    @RequestMapping("/login")
    public String login(String username, String password,String email, HttpSession session) throws UnsupportedEncodingException {
        try {
            //login
            User user = UserService.login(username,password,email);
            //登陆成功保存用户登陆的标记
            session.setAttribute("user",user);
            return "forward:/toppage.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login?msg =" + URLEncoder.encode(e.getMessage(),"UTF-8");

        }

    }

    /*
     * register機能
     * 関数名：register
     * 機能：register機能
     * 引数：User user
     *      BindingResult bindingResult
     *      Role role
     *      Model model
     * 戻り値：register
     * バージョン：1.000.000 by wangyd
     */
    @PostMapping("/register")
    public  String register(@Valid User user, BindingResult bindingResult, Role role, Model model, HttpSession session) {
        log.debug("用户名：{},邮箱：{}，密码：{}，类别：{}",user.getUName(),user.getUPassword(),user.getMail(),role.getRtype());

        try {
            Map<String,Object> map = new HashMap<>();
            if(bindingResult.hasErrors()){
                List<FieldError> fieldErrors = bindingResult.getFieldErrors();
                //遍历报错信息集合取出每一个
                for (FieldError fieldError:fieldErrors) {
                    System.out.println(fieldError.getField());
                    System.out.println(fieldError.getDefaultMessage());
                    map.put(fieldError.getField(),fieldError.getDefaultMessage());
                    }
                model.addAttribute("errorInfo",map);
                System.out.println("登录失败");
               }

            if (!Objects.equals(user.getMail(), "")){
//2022.08.12 by wangyd update start version.1.000.000
                UserRole userRole = new UserRole();
                //1,注册用户
//                UserService.register(user,role,new UserRole());
                UserService.register(user,role,userRole);
                session.setAttribute("user",user);
                session.setAttribute("role",role);
                session.setAttribute("userRole",userRole);
//2022.08.12 by wangyd update end
            }else {
                return "forward:/register";
            }

        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/register";
        }

        return "redirect:/login.jsp";
    }

}
