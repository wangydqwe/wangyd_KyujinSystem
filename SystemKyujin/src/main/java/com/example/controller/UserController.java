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


//用户开发功能
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService UserService;

    public UserController(com.example.service.UserService userService) {
        UserService = userService;
    }
    /*
     * login
     * @return
     */
    @RequestMapping("login")
    public String login(String username, String password,String email, HttpSession session) throws UnsupportedEncodingException {
        log.debug("用户名：{},密码：{},邮箱：{}",username,password,email);

        try {
            //login
            User user = UserService.login(username,password,email);
            //登陆成功保存用户登陆的标记
            session.setAttribute("user",user);
            return "redirect:/toppage.jsp";
        }catch (Exception e){
            e.printStackTrace();
            return "redirect:/login.jsp?msg =" + URLEncoder.encode(e.getMessage(),"UTF-8");

        }

    }



    /*
     *用户注册
     *@return
     */
    @PostMapping("/register")
    public  String register(@Valid User user, BindingResult bindingResult, Role role, Model model) {
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
                //1,注册用户
                UserService.register(user,role,new UserRole());
            }else {
                return "forward:/register.jsp";
            }

        }catch (RuntimeException e){
            e.printStackTrace();
            return "forward:/register.jsp";
        }

        return "redirect:/login.jsp";
    }
}
