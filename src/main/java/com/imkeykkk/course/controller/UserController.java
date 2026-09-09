package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.UserMapper;
import com.imkeykkk.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> list() {
        return userService.list();
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password){
        User user = userService.findByUsername(username);
        if(user == null){
            return "用户不存在";
        }
        if(user.getPassword().equals(password)){
            return "登录成功，欢迎"+user.getRealName();
        }
        else{
            return "密码错误";
        }
    }
}