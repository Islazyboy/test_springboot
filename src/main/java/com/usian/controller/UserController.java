package com.usian.controller;

import com.usian.entity.User;
import com.usian.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/queryUser")
    public String queryUser(User user, HttpServletRequest request, HttpServletResponse response, Model model){
        if(userService.select(user)){
            request.getSession().setAttribute("user",user);
        }else {
            model.addAttribute("msg","您输入的用户名或密码有误！！！");
            return "login";
        }
        return "redirect:/emp/goShow";
    }
}
