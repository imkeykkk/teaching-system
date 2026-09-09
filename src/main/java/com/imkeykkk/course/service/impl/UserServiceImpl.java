package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.UserMapper;
import com.imkeykkk.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();//QueryWrapper 是 MyBatis-Plus 框架中用于构建 SQL 查询条件的工具类‌
        wrapper.eq("username",username);//eq("字段", 值)：等于，如.eq("age", 18) 生成 age = 18。
        return userMapper.selectOne(wrapper);//selectOne 方法有一个致命陷阱：‌如果数据库中有两条及以上用户的 username 相同，它会抛出 TooManyResultsException 异常‌。
        //所以后面应该要对这条语句做处理，
    }

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }



}
