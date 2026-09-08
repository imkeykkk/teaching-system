package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/users")
    public List<User> list() {
        return userMapper.selectList(null);
    }
}