package com.imkeykkk.course.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.imkeykkk.course.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}