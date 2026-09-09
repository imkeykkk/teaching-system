package com.imkeykkk.course.service;

import com.imkeykkk.course.entity.User;

import java.util.List;

public interface UserService {
    User findByUsername(String username);

    List<User> list();

    boolean login(String username, String rawPassword);
}
