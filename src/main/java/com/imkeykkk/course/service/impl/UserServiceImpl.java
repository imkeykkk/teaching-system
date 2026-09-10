package com.imkeykkk.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.UserMapper;
import com.imkeykkk.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired//Autowired会通过类型PasswordEncoder匹配Bean，但是如果有多个同类型的Bean，会通过变量名passwordEncoder匹配，或者可以通过@Qualifier显示指定
    private PasswordEncoder passwordEncoder;

    @Override
    public User findByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();//QueryWrapper 是 MyBatis-Plus 框架中用于构建 SQL 查询条件的工具类‌
        wrapper.eq("username",username);//eq("字段", 值)：等于，如.eq("age", 18) 生成 age = 18。
        return userMapper.selectOne(wrapper);//selectOne 方法有一个致命陷阱：‌如果数据库中有两条及以上用户的 username 相同，它会抛出 TooManyResultsException 异常‌。
        //所以后面应该要对这条语句做处理，
        //为什么不直接用mapper中的方法呢，因为没有，内置的单表快捷方法主要根据主键id来查询，否则就是传入wrapper查询，例如下面这个getById方法
    }

    @Override
    public User getById(Long id) {

        return userMapper.selectById(id);

        /*QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        return userMapper.selectOne(wrapper);也可以这么用*/
    }

    @Override
    public List<User> list() {
        return userMapper.selectList(null);
    }

    @Override
    public boolean login(String username, String rawPassword) {
        User user = findByUsername(username);
        if(user==null){
            return false;
        }
        return  passwordEncoder.matches(rawPassword,user.getPassword());
    }


}
